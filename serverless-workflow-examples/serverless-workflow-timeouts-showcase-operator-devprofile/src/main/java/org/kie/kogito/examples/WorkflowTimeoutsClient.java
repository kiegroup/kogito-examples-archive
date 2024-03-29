/*
 * Copyright 2023 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.kogito.examples;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.kie.kogito.examples.WorkflowTimeoutsClient.CONFIG_KEY;

@Path("/")
@RegisterRestClient(configKey = CONFIG_KEY)
public interface WorkflowTimeoutsClient extends WorkflowClient {

    /**
     * SW id that was configured in the workflow_timeouts.yaml.
     */
    String ID = "workflowtimeouts";
    String URI = "/" + ID;
    String CONFIG_KEY = "workflow_timeouts";

    @POST
    @Path(URI)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response post(@Context HttpHeaders httpHeaders, @QueryParam("businessKey") @DefaultValue("") String businessKey, String input);

    @GET
    @Path(URI)
    @Produces(MediaType.APPLICATION_JSON)
    Response get();

}
