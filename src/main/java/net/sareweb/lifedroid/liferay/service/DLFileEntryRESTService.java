package net.sareweb.lifedroid.liferay.service;

import net.sareweb.lifedroid.liferay.service.generic.LDRESTService;
import net.sareweb.lifedroid.model.DLFileEntry;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class DLFileEntryRESTService extends LDRESTService<DLFileEntry> {

	public DLFileEntryRESTService(String emailAddress, String password) {
		super(emailAddress, password);
	}
	
	
	public DLFileEntry addFileEntry(DLFileEntry dlFileEntry, String fileFolderPath) {
		RestTemplate rt = new RestTemplate(requestFactory);
		String requestURL = _serviceURI + "/dlapp/add-file-entry/";

		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		
		parts.add("repositoryId", dlFileEntry.getRepositoryId().toString());
		parts.add("folderId", dlFileEntry.getFolderId().toString());
		parts.add("sourceFileName",dlFileEntry.getSourceFileName());
		parts.add("mimeType", dlFileEntry.getMimeType());
		parts.add("title", dlFileEntry.getSourceFileName());
		parts.add("description", "a");
		parts.add("changeLog", "a");
		parts.add("serviceContext", "{}");
		
		
		Resource fileResource = new FileSystemResource(fileFolderPath + "/" + dlFileEntry.getSourceFileName());
		parts.add("file", fileResource);
		
		String jsonString = rt.postForObject(requestURL, parts, String.class);
		
		return getObjectFromJsonString(jsonString);
	}

	@Override
	public void setPorltetContext() {

	}

}
