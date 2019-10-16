/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1.conversation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook extends Resource {
    private static final long serialVersionUID = 99232637584802L;

    public enum Target {
        WEBHOOK("webhook"),
        TRIGGER("trigger"),
        STUDIO("studio");

        private final String value;

        private Target(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Target from a string.
         * @param value string value
         * @return generated Target
         */
        @JsonCreator
        public static Target forValue(final String value) {
            return Promoter.enumFromString(value, Target.values());
        }
    }

    public enum Method {
        GET("GET"),
        POST("POST");

        private final String value;

        private Method(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Method from a string.
         * @param value string value
         * @return generated Method
         */
        @JsonCreator
        public static Method forValue(final String value) {
            return Promoter.enumFromString(value, Method.values());
        }
    }

    /**
     * Create a WebhookReader to execute read.
     *
     * @param pathConversationSid The unique id of the Conversation for this
     *                            webhook.
     * @return WebhookReader capable of executing the read
     */
    public static WebhookReader reader(final String pathConversationSid) {
        return new WebhookReader(pathConversationSid);
    }

    /**
     * Create a WebhookFetcher to execute fetch.
     *
     * @param pathConversationSid The unique id of the Conversation for this
     *                            webhook.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return WebhookFetcher capable of executing the fetch
     */
    public static WebhookFetcher fetcher(final String pathConversationSid,
                                         final String pathSid) {
        return new WebhookFetcher(pathConversationSid, pathSid);
    }

    /**
     * Create a WebhookCreator to execute create.
     *
     * @param pathConversationSid The unique id of the Conversation for this
     *                            webhook.
     * @param target The target of this webhook.
     * @return WebhookCreator capable of executing the create
     */
    public static WebhookCreator creator(final String pathConversationSid,
                                         final Webhook.Target target) {
        return new WebhookCreator(pathConversationSid, target);
    }

    /**
     * Create a WebhookUpdater to execute update.
     *
     * @param pathConversationSid The unique id of the Conversation for this
     *                            webhook.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return WebhookUpdater capable of executing the update
     */
    public static WebhookUpdater updater(final String pathConversationSid,
                                         final String pathSid) {
        return new WebhookUpdater(pathConversationSid, pathSid);
    }

    /**
     * Create a WebhookDeleter to execute delete.
     *
     * @param pathConversationSid The unique id of the Conversation for this
     *                            webhook.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return WebhookDeleter capable of executing the delete
     */
    public static WebhookDeleter deleter(final String pathConversationSid,
                                         final String pathSid) {
        return new WebhookDeleter(pathConversationSid, pathSid);
    }

    /**
     * Converts a JSON String into a Webhook object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Webhook object represented by the provided JSON
     */
    public static Webhook fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Webhook object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Webhook object represented by the provided JSON
     */
    public static Webhook fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String conversationSid;
    private final String target;
    private final URI url;
    private final Map<String, Object> configuration;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private Webhook(@JsonProperty("sid")
                    final String sid,
                    @JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("conversation_sid")
                    final String conversationSid,
                    @JsonProperty("target")
                    final String target,
                    @JsonProperty("url")
                    final URI url,
                    @JsonProperty("configuration")
                    final Map<String, Object> configuration,
                    @JsonProperty("date_created")
                    final String dateCreated,
                    @JsonProperty("date_updated")
                    final String dateUpdated) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.conversationSid = conversationSid;
        this.target = target;
        this.url = url;
        this.configuration = configuration;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The A 34 character string that uniquely identifies this resource..
     *
     * @return A 34 character string that uniquely identifies this resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The unique id of the Account responsible for this conversation..
     *
     * @return The unique id of the Account responsible for this conversation.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The unique id of the Conversation for this webhook..
     *
     * @return The unique id of the Conversation for this webhook.
     */
    public final String getConversationSid() {
        return this.conversationSid;
    }

    /**
     * Returns The The target of this webhook..
     *
     * @return The target of this webhook.
     */
    public final String getTarget() {
        return this.target;
    }

    /**
     * Returns The An absolute URL for this webhook..
     *
     * @return An absolute URL for this webhook.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The configuration of this webhook..
     *
     * @return The configuration of this webhook.
     */
    public final Map<String, Object> getConfiguration() {
        return this.configuration;
    }

    /**
     * Returns The The date that this resource was created..
     *
     * @return The date that this resource was created.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated..
     *
     * @return The date that this resource was last updated.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Webhook other = (Webhook) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(conversationSid, other.conversationSid) &&
               Objects.equals(target, other.target) &&
               Objects.equals(url, other.url) &&
               Objects.equals(configuration, other.configuration) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            conversationSid,
                            target,
                            url,
                            configuration,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("conversationSid", conversationSid)
                          .add("target", target)
                          .add("url", url)
                          .add("configuration", configuration)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}