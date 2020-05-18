package com.example.init;

import com.example.model.RegistrationRequest;
import com.example.model.UserDetails;
import com.example.repository.RequestsRepository;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

	@Inject
    private RequestsRepository requestsRepository;

	@Override
	public void onApplicationEvent(ServerStartupEvent event) {
		RegistrationRequest r = new RegistrationRequest();
		r.setKey("sometestkey");

		UserDetails u = new UserDetails();
		u.setName("TestName");
		u.setPassword("somepassword");
		u.setEmail("some@email.com");
		r.setUserDetails(u);

		if (requestsRepository.existsByKey(r.getKey())) {
			return;
		}
		requestsRepository.save(r);
	}
}
