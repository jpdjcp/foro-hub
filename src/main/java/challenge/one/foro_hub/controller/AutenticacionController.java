package challenge.one.foro_hub.controller;

import challenge.one.foro_hub.dto.DatosAutenticacion;
import challenge.one.foro_hub.dto.DatosTokenJWT;
import challenge.one.foro_hub.entity.Usuario;
import challenge.one.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
        var autenticacionToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());                         // tokeniza usuario y contrasena
        var autenticacion = manager.authenticate(autenticacionToken);
        var usuario = (Usuario) autenticacion.getPrincipal();
        var tokenJWT = tokenService.generarToken(usuario);
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}
