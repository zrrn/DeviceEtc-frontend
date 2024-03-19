package bean;

import java.util.List;
import javax.annotation.ManagedBean;
import service.DeviceBackendClient;
import java.util.ArrayList;
import javax.ws.rs.core.Response;

import javax.faces.bean.ViewScoped;

import controller.DeviceController;
import model.Device;
import model.DeviceListResponse;

@ManagedBean
@ViewScoped
public class DeviceBean {
	private List<Device> devicelist;
	private Device device;
	private DeviceBackendClient deviceBackend;
	private DeviceController deviceController;

	public DeviceBean() {
		devicelist = new ArrayList<Device>();
		device = new Device();
		deviceBackend = new DeviceBackendClient();
		deviceController = new DeviceController();
	}

	// cihazlist metodunu çağır
	public List<Device> getDeviceList() {
		DeviceListResponse resSummary = deviceController.getDeviceList();
		devicelist = resSummary.getDeviceList();
		return devicelist;
	}

	// save metodu çağır
	public Boolean saveDevice() {
		Boolean is_true = false;
		Response response = deviceController.saveDevice(device);
		if (response.getStatus() == 200) {
			is_true = true;
		} else {
			is_true = false;
		}
		return is_true;
	}

	// delete metodu çağır
	public void deleteDevice() {
		deviceController.deleteDevice(device.getId());
	}

	// update metodu çağır
	public Boolean updateDevice() {
		Boolean is_true = false;
		Response response = deviceController.updateDevice(device);
		if (response.getStatus() == 200) {
			is_true = true;
		} else {
			is_true = false;
		}
		return is_true;
	}

	// cihazdan bildirim alma metodunu çağır
	public Boolean notifyDeviceLocation() {
		Boolean is_true = false;
		Response response = deviceController.notifyDeviceLocation(device);
		if (response.getStatus() == 200) {
			is_true = true;
		} else {
			is_true = false;
		}
		return is_true;
	}
	
	// id ye göre cihaz find
		public Device checkDeviceDef() {
			Device resDevice = deviceController.checkDeviceDef(device.getId());
			return resDevice;
		}
		

	public void setDevicelist(List<Device> devicelist) {
		this.devicelist = devicelist;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	/*
	 * public void updateApproveStatus(UpdateApproveStatusRequest
	 * updateApproveStatusRequest) {
	 * 
	 * return
	 * client.target(REST_URI).path("manuel-excel-import").path("approve-status").
	 * request(MediaType.APPLICATION_JSON).post(Entity.entity(
	 * updateApproveStatusRequest, MediaType.APPLICATION_JSON)); }
	 */
}
