package error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class RutaNotFoundException extends ErrorResponseException {

    public RutaNotFoundException(Long id){
        super(HttpStatus.NOT_FOUND,asProblemDetail("la entidad lugar con el id "+id+" no se ha encontrado"),null);
    }
    private static ProblemDetail asProblemDetail(String mensaje){
        ProblemDetail problemaDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,mensaje);
        problemaDetail.setTitle(" ruta not found");
        problemaDetail.setType(URI.create("https://api.lugar.com/errors/not-found"));
        problemaDetail.setProperty("errorCategory","generic");
        problemaDetail.setProperty("timestamp", Instant.now());
        return problemaDetail;
    }
}
