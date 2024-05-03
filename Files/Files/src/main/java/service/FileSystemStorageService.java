package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
@Service
public class FileSystemStorageService implements StorageService{
    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties){
        if (properties.getLocation().trim().length() == 0){
            throw  new StorageException("file upload location cant not be Empty");

        }
        this.rootLocation = Paths.get(properties.getLocation());
    }
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }catch (IOException e){
            throw new StorageException("could not initalize storage",e);
        }
    }

    @Override
    public void store(MultipartFile multipartFile) {
        try{
            if (multipartFile.isEmpty()){
                throw new StorageException("Failed to store empty file");
            }
            Path destinoFile = this.rootLocation.resolve(Paths.get(multipartFile.getOriginalFilename())).normalize().toAbsolutePath();
            if (!destinoFile.getParent().equals(this.rootLocation.toAbsolutePath())){
                throw new StorageException("can not store file outside current directory");
            }
            try (InputStream inputStream = multipartFile.getInputStream()){
                Files.copy(inputStream,destinoFile, StandardCopyOption.REPLACE_EXISTING);
            }

        }
        catch (IOException e){
            throw new StorageException("Failed to store file.",e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try{
            return Files.walk(this.rootLocation,1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
        }catch (IOException e){
            throw new StorageException("failed to read stored files",e);
        }
    }

    @Override
    public Path load(String fileName) {
        return rootLocation.resolve(fileName);
    }

    @Override
    public Resource loadAsResource(String fleName) {
        try {
            Path file = load(fleName);
            Resource resource =  new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new StorageFileNotFoundException("could not read file:"+fleName);
            }
        }
        catch (MalformedURLException e){
            throw new StorageFileNotFoundException("could not read file"+fleName,e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
