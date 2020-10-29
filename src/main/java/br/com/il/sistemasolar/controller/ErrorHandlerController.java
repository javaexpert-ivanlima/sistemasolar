package br.com.il.sistemasolar.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController implements ErrorController{

	@Override
	@RequestMapping("/error")
	@ResponseBody
	public String getErrorPath() {
		return "<center><h1>Por favor, verifique a url digitada</h1></center>";
	}
}