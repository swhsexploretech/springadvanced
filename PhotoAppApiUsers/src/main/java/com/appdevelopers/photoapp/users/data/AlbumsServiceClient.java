package com.appdevelopers.photoapp.users.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appdevelopers.photoapp.users.model.AlbumResponseModel;

@FeignClient(name="albums-ws")
public interface AlbumsServiceClient {
	
	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);

}


