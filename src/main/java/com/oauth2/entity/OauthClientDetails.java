package com.oauth2.entity;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table oauth_client_details
 */
public class OauthClientDetails implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.client_id
     *
     * @mbg.generated
     */
    private String clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.resource_ids
     *
     * @mbg.generated
     */
    private String resourceIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.client_secret
     *
     * @mbg.generated
     */
    private String clientSecret;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.scope
     *
     * @mbg.generated
     */
    private String scope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.authorized_grant_types
     *
     * @mbg.generated
     */
    private String authorizedGrantTypes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.web_server_redirect_uri
     *
     * @mbg.generated
     */
    private String webServerRedirectUri;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.authorities
     *
     * @mbg.generated
     */
    private String authorities;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.access_token_validity
     *
     * @mbg.generated
     */
    private Integer accessTokenValidity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.refresh_token_validity
     *
     * @mbg.generated
     */
    private Integer refreshTokenValidity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.additional_information
     *
     * @mbg.generated
     */
    private String additionalInformation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_client_details.autoapprove
     *
     * @mbg.generated
     */
    private String autoapprove;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oauth_client_details
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.client_id
     *
     * @return the value of oauth_client_details.client_id
     *
     * @mbg.generated
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.client_id
     *
     * @param clientId the value for oauth_client_details.client_id
     *
     * @mbg.generated
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.resource_ids
     *
     * @return the value of oauth_client_details.resource_ids
     *
     * @mbg.generated
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.resource_ids
     *
     * @param resourceIds the value for oauth_client_details.resource_ids
     *
     * @mbg.generated
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.client_secret
     *
     * @return the value of oauth_client_details.client_secret
     *
     * @mbg.generated
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.client_secret
     *
     * @param clientSecret the value for oauth_client_details.client_secret
     *
     * @mbg.generated
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.scope
     *
     * @return the value of oauth_client_details.scope
     *
     * @mbg.generated
     */
    public String getScope() {
        return scope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.scope
     *
     * @param scope the value for oauth_client_details.scope
     *
     * @mbg.generated
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.authorized_grant_types
     *
     * @return the value of oauth_client_details.authorized_grant_types
     *
     * @mbg.generated
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.authorized_grant_types
     *
     * @param authorizedGrantTypes the value for oauth_client_details.authorized_grant_types
     *
     * @mbg.generated
     */
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes == null ? null : authorizedGrantTypes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.web_server_redirect_uri
     *
     * @return the value of oauth_client_details.web_server_redirect_uri
     *
     * @mbg.generated
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.web_server_redirect_uri
     *
     * @param webServerRedirectUri the value for oauth_client_details.web_server_redirect_uri
     *
     * @mbg.generated
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri == null ? null : webServerRedirectUri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.authorities
     *
     * @return the value of oauth_client_details.authorities
     *
     * @mbg.generated
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.authorities
     *
     * @param authorities the value for oauth_client_details.authorities
     *
     * @mbg.generated
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.access_token_validity
     *
     * @return the value of oauth_client_details.access_token_validity
     *
     * @mbg.generated
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.access_token_validity
     *
     * @param accessTokenValidity the value for oauth_client_details.access_token_validity
     *
     * @mbg.generated
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.refresh_token_validity
     *
     * @return the value of oauth_client_details.refresh_token_validity
     *
     * @mbg.generated
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.refresh_token_validity
     *
     * @param refreshTokenValidity the value for oauth_client_details.refresh_token_validity
     *
     * @mbg.generated
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.additional_information
     *
     * @return the value of oauth_client_details.additional_information
     *
     * @mbg.generated
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.additional_information
     *
     * @param additionalInformation the value for oauth_client_details.additional_information
     *
     * @mbg.generated
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation == null ? null : additionalInformation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_client_details.autoapprove
     *
     * @return the value of oauth_client_details.autoapprove
     *
     * @mbg.generated
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_client_details.autoapprove
     *
     * @param autoapprove the value for oauth_client_details.autoapprove
     *
     * @mbg.generated
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove == null ? null : autoapprove.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OauthClientDetails other = (OauthClientDetails) that;
        return (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getResourceIds() == null ? other.getResourceIds() == null : this.getResourceIds().equals(other.getResourceIds()))
            && (this.getClientSecret() == null ? other.getClientSecret() == null : this.getClientSecret().equals(other.getClientSecret()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()))
            && (this.getAuthorizedGrantTypes() == null ? other.getAuthorizedGrantTypes() == null : this.getAuthorizedGrantTypes().equals(other.getAuthorizedGrantTypes()))
            && (this.getWebServerRedirectUri() == null ? other.getWebServerRedirectUri() == null : this.getWebServerRedirectUri().equals(other.getWebServerRedirectUri()))
            && (this.getAuthorities() == null ? other.getAuthorities() == null : this.getAuthorities().equals(other.getAuthorities()))
            && (this.getAccessTokenValidity() == null ? other.getAccessTokenValidity() == null : this.getAccessTokenValidity().equals(other.getAccessTokenValidity()))
            && (this.getRefreshTokenValidity() == null ? other.getRefreshTokenValidity() == null : this.getRefreshTokenValidity().equals(other.getRefreshTokenValidity()))
            && (this.getAdditionalInformation() == null ? other.getAdditionalInformation() == null : this.getAdditionalInformation().equals(other.getAdditionalInformation()))
            && (this.getAutoapprove() == null ? other.getAutoapprove() == null : this.getAutoapprove().equals(other.getAutoapprove()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getResourceIds() == null) ? 0 : getResourceIds().hashCode());
        result = prime * result + ((getClientSecret() == null) ? 0 : getClientSecret().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
        result = prime * result + ((getAuthorizedGrantTypes() == null) ? 0 : getAuthorizedGrantTypes().hashCode());
        result = prime * result + ((getWebServerRedirectUri() == null) ? 0 : getWebServerRedirectUri().hashCode());
        result = prime * result + ((getAuthorities() == null) ? 0 : getAuthorities().hashCode());
        result = prime * result + ((getAccessTokenValidity() == null) ? 0 : getAccessTokenValidity().hashCode());
        result = prime * result + ((getRefreshTokenValidity() == null) ? 0 : getRefreshTokenValidity().hashCode());
        result = prime * result + ((getAdditionalInformation() == null) ? 0 : getAdditionalInformation().hashCode());
        result = prime * result + ((getAutoapprove() == null) ? 0 : getAutoapprove().hashCode());
        return result;
    }
}