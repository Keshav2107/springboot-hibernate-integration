package com.example.sbhi.utility;

import org.springframework.http.HttpStatus;


public final class RelationshipServiceUtility {

    private RelationshipServiceUtility() {

    }

    /**
     * Utility method for constructing a RepsonseMessage.
     * 
     * @param statusCode
     *            - The Status Code to be set in ResponseMessage
     * @param statusMessage
     *            - The Status Message to be set in ResponseMessage
     * @return - Returns a ResponseMessage object
     */
  /*  public static ResponseMessage createResponseMessage(final String statusCode,
            final String statusMessage,final String referenceNumber) {
        return new ResponseMessage(statusCode, statusMessage, referenceNumber);
    }
*/
    /**
     * Utility method for constructing a BadRequest ResponseMessage.
     * 
     * @param spanId
     *            - The Span ID to be included in the Response Message
     * @param exceptionMessage
     *            - The exception message to be included in the Response Message
     * @return - Returns a ResponseMessage object
     */
  /*  public static ResponseMessage createBadReqResponseMessage(final String spanId,
            final String exceptionMessage) {

        return createResponseMessage(HttpStatus.BAD_REQUEST.toString(), exceptionMessage, spanId);
    }*/

    /**
     * Utility method for constructing an InternalServer ResponseMessage.
     * 
     * @param spanId
     *            - The Span ID to be included in the Response Message
     * @param exceptionMessage
     *            - The exception message to be included in the Response Message
     * @return - Returns a ResponseMessage object
     */
    /*public static ResponseMessage createInternalServerResponseMessage(final String spanId,
            final String exceptionMessage) {

        return createResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exceptionMessage,
                spanId);
    }*/

    /**
     * Utility method for constructing a successful ResponseMessage.
     * 
     * @param spanId
     *            - The Span ID to be included in the Response Message
     * @param message
     *            - The success message to be included in the Response Message
     * @return - Returns a ResponseMessage object
     */
   /* public static ResponseMessage createSuccessResponseMessage(final String spanId,
            final String message) {

        return createResponseMessage(HttpStatus.OK.toString(), message, spanId);
    }*/
}
