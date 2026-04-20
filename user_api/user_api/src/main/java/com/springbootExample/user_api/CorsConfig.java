import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permetti l'invio di cookie o header di autenticazione
        config.setAllowCredentials(true);

        // Specifica l'indirizzo esatto del tuo frontend React
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));

        // Autorizza tutti gli header (Content-Type, Authorization, ecc.)
        config.setAllowedHeaders(Arrays.asList("*"));

        // Autorizza tutti i metodi HTTP (fondamentale per DELETE e OPTIONS)
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Applica questa configurazione a tutti i percorsi dell'API
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}