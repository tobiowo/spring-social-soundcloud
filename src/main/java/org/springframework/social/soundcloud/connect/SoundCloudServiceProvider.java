package org.springframework.social.soundcloud.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.soundcloud.api.SoundCloud;
import org.springframework.social.soundcloud.api.impl.SoundCloudTemplate;

/**
* SoundCloud ServiceProvider implementation.
* @author Michael Lavelle
*/
public class SoundCloudServiceProvider extends AbstractOAuth2ServiceProvider<SoundCloud>{

	private String clientId;
	
	public SoundCloudServiceProvider(String clientId, String clientSecret) {
		this(clientId,clientSecret,null);
	}
	

	public SoundCloudServiceProvider(String clientId, String clientSecret,String redirectUri) {
		super(new SoundCloudOAuth2Template(clientId, clientSecret,redirectUri));
		}

	@Override
	public SoundCloud getApi(String accessToken) {
		return new SoundCloudTemplate(clientId,accessToken);
	}

}
