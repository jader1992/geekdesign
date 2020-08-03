package com.company.lsp;

public class SecurityTransporter extends Transporter {
    private String appId;
    private String appToken;

    public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
        super(httpClient);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public Response SendRequest() {
        if(StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appToken)) {
            throw new NoAuthorizationRuntimeException(...);
        }
        request.addPayload("app-id",appId);
        request.addPayload("app-token", appToken);
        return super.SendRequest(request);
    }
}
