package com.lauraprog.demoConcesionario;

import com.lauraprog.demoConcesionario.DemoConcesionarioApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoConcesionarioApplication.class);
	}

}
