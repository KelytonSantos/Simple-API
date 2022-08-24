package com.springboot.lucas.demo.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.lucas.demo.service.exception.DatabaseException;
import com.springboot.lucas.demo.service.exception.ResourceNotFoundException;

//Nosso erro é construido de algumas etapas: temos a etapa na qual eu pego os erros no service(notFound or Other)
//A etapa em que as coisas aparecem na tela(StandardError)
//E a etapa(essa eta intermediaria é justamente essa classe) em que eu preencho essa classe(StandardError) com os dados que eu capturei e mais alguns dados que eu adiciono(estes não vindo do erro capturado)
//É bom deixar claro que na classe de service eu apenas lanço o erro
//No Controller eu trato esse erro e imprimo na tela
@ControllerAdvice //intercepta as exceções que acaso venham a acontecer e então o objeto executa um possível tratamento 
public class ResourceExceptionsHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)//aqui eu digo que meu método vai interceptar qualquer exceção desse tipo(no .class); e ai eu faço o tratamento no meu método criado
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;//aqui eu adiciono o not found a minha variavel status do tipo HttpStatus
        StandardError err = new StandardError(Instant.now()/*instante de agora*/, status.value()/*aqui eu pego o status e transformo para inteiro*/,
        error/*mensagem de erro criado mais a cima*/,
         e.getMessage()/*mensagem vinda do ResourceNotFoundException*/, request.getRequestURI())/*aqui eu pego o path*/;
         return ResponseEntity.status(status).body(err);
    } //esse foi o tratamento de erro do 400 not found


    @ExceptionHandler(DatabaseException.class)//to falando que meu método vai interceptar qualquer exceção desse tipo aqui(no .class); e ai eu faço o tratamento no meu método criado
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now()/*instante de agora*/, status.value()/*aqui eu pego o status e transformo para inteiro*/,
         error/*mensagem de erro criado mais a cima*/,
          e.getMessage()/*mensagem vinda do ResourceNotFoundException*/, request.getRequestURI())/*aqui eu pego o path*/;
          return ResponseEntity.status(status).body(err);//meu body é o err
    } //esse foi o tratamento de um erro mais geral(bad request)
}