package com.boldijarpaul.backend.servlets;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import entities.GcmData;
import entities.GcmModel;

@Path("/push")
public class PushServlet {

	private static final String GCM = "https://gcm-http.googleapis.com/gcm/send";
	private static OkHttpClient client = new OkHttpClient();

	private String sendNotification(String message) throws IOException {
		GcmModel gcmModel = new GcmModel("/topics/all", new GcmData(message));

		String json = new Gson().toJson(gcmModel);

		Request request = new Request.Builder()
				.addHeader("Authorization",
						"key=AIzaSyDLhXqM-Y-o46j_THzQY8QLCbN2lD7_4T4")
				.url(GCM)
				.post(RequestBody.create(
						MediaType.parse("application/json; charset=utf-8"),
						json)).build();
		return client.newCall(request).execute().body().string();
	}

	@GET
	@Path("")
	public String getText(@QueryParam("message") String message)
			throws IOException {
		return sendNotification(message == null ? "Hello!" : message);

	}
}
