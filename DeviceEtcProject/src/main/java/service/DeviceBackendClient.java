package service;

import model.Device;
import model.DeviceListResponse;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DeviceBackendClient {

    private Client client = ClientBuilder.newClient();

	private static final String REST_URI = "http://localhost:8080";
	
	public DeviceBackendClient() {
		// TODO Auto-generated constructor stub
	}
	
	//devicelist backend servis çağrılır
	public DeviceListResponse deviceListResponse() {
		
		return client.target(REST_URI).path("device").path("list").request(MediaType.APPLICATION_JSON).get(DeviceListResponse.class);}

	//create backend servis çağrılır
	public Response createDeviceDef(Device createDeviceRequest) {
		
		return client.target(REST_URI).path("device").path("create").request(MediaType.APPLICATION_JSON).post(Entity.entity(createDeviceRequest, MediaType.APPLICATION_JSON));	
	}
	
	//update backend servis çağrılır
	public Response updateDeviceDef(Device updateDeviceRequest) {
		
		return client.target(REST_URI).path("device").path("update").request(MediaType.APPLICATION_JSON).put(Entity.entity(updateDeviceRequest, MediaType.APPLICATION_JSON));	
	}
	
   //Id ye göre cihaz bilgisi çeken servis çağrılır
	public Device checkDeviceDef(Long id) {

		Device getByIdResponse = client.target(REST_URI).path("device")				
				.path("get").queryParam("id", id)
				.request(MediaType.APPLICATION_JSON).get(Device.class);
		return getByIdResponse;
	}
	  //silme servis çağrılır
		public void deleteDeviceDef(Long id) {

			Device getByIdResponse = client.target(REST_URI).path("device")				
					.path("delete").queryParam("id", id)
					.request(MediaType.APPLICATION_JSON).delete(Device.class);
		}
	//notify location backend servis çağrılır
	public Response notifyLocationDef(Device notifyLocationRequest) {
		
		return client.target(REST_URI).path("device").path("notify-location").request(MediaType.APPLICATION_JSON).post(Entity.entity(notifyLocationRequest, MediaType.APPLICATION_JSON));	
	}
}
