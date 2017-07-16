/*
 * Copyright 2017 Hewlett-Packard Enterprise Development Company, L.P.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hpe.adm.nga.sdk.entities;

import com.hpe.adm.nga.sdk.model.EntityModel;
import com.hpe.adm.nga.sdk.network.OctaneHttpClient;
import com.hpe.adm.nga.sdk.network.OctaneHttpRequest;
import com.hpe.adm.nga.sdk.network.OctaneRequest;

/**
 * This class hold the GetEntities object of one entity
 */
public class GetEntity extends OctaneRequest {

    protected GetEntity(OctaneHttpClient octaneHttpClient, String urlDomain, String entityId) {
        super(octaneHttpClient, urlDomain, entityId);
    }

    /**
     * 1. GetEntities Request execution with json data 2. Parse response to a
     * new EntityModel object
     */
    public EntityModel execute() throws RuntimeException {

        EntityModel newEntityModel = null;
        try {
            OctaneHttpRequest octaneHttpRequest =
                    new OctaneHttpRequest.GetOctaneHttpRequest(getFinalRequestUrl())
                            .setAcceptType(OctaneHttpRequest.JSON_CONTENT_TYPE);
            newEntityModel = getEntityResponse(octaneHttpRequest);
        } catch (Exception e) {

            handleException(e, false);
        }

        return newEntityModel;

    }

    /**
     * Set Fields Parameters
     *
     * @param fields An array or comma separated list of fields to be retrieved
     * @return a new GetEntities object with new Fields Parameters
     */
    public GetEntity addFields(String... fields) {
        getOctaneUrl().addFieldsParam(fields);
        return this;
    }
}
