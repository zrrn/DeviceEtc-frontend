package controller;

import java.util.List;

import javax.ws.rs.core.Response;

import service.DeviceBackendClient;
import model.Device;
import model.DeviceListResponse;

public class DeviceController {

	private DeviceBackendClient deviceBackend;
	
	public DeviceController() {
		// TODO Auto-generated constructor stub

		deviceBackend = new DeviceBackendClient();
	}
	
	 public DeviceListResponse getDeviceList() {
		 DeviceListResponse resSummary = deviceBackend.deviceListResponse();
		 return resSummary	;
	    }
	 
	 public Response saveDevice(Device device) {
			Response response = deviceBackend.createDeviceDef(device);
			return response;
		}

		// delete metodu çağır
		public void deleteDevice(Long id) {
			deviceBackend.deleteDeviceDef(id);
		}

		// update metodu çağır
		public Response updateDevice(Device device) {
			Response response = deviceBackend.updateDeviceDef(device);
			return response;
		}

		// cihazdan bildirim alma metodunu çağır
		public Response notifyDeviceLocation(Device device) {
			Response response = deviceBackend.notifyLocationDef(device);
			return response;
		}
		
		// id ye göre cihaz find
			public Device checkDeviceDef(Long id) {
				Device resDevice = deviceBackend.checkDeviceDef(id);
				return resDevice;
			}
			
}
