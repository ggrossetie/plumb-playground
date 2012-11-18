package sample.client.message;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.enterprise.client.cdi.api.Conversational;

@Portable
@Conversational
public class Response {

	private int progress;

	public Response() {
	}

	public Response(int progress) {
		this.progress = progress;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
}