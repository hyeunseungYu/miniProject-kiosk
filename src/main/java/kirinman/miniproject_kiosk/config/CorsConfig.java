package kirinman.miniproject_kiosk.config;//package miniProject.kiosk.config;
//
//import miniProject.kiosk.jwt.JwtUtil;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true); // 이 서버의 응답을 js가 처리할 수 있다.
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//
//        config.setMaxAge(3600L);
//        config.addExposedHeader(JwtUtil.AUTHORIZATION_HEADER);
//        source.registerCorsConfiguration("/",config);
//        return new CorsFilter(source);
//    }
//}
