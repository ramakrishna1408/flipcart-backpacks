/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package flipcart.life.provider;

import org.apache.tuscany.sca.assembly.Endpoint;
import org.apache.tuscany.sca.assembly.EndpointReference;
import org.apache.tuscany.sca.core.ExtensionPointRegistry;
import org.apache.tuscany.sca.provider.PolicyProvider;
import org.apache.tuscany.sca.provider.PolicyProviderFactory;
import org.apache.tuscany.sca.runtime.RuntimeComponent;

import flipcart.life.lifePolicy;

/**
 * @version $Rev$ $Date$
 */
public class lifePolicyProviderFactory implements PolicyProviderFactory<lifePolicy> {
    private ExtensionPointRegistry registry;
    
    public lifePolicyProviderFactory(ExtensionPointRegistry registry) {
        super();
        this.registry = registry;
    }

    /**
     * @see flipcart.provider.PolicyProviderFactory#createImplementationPolicyProvider(flipcart.runtime.RuntimeComponent, flipcart.assembly.Implementation)
     */
    @Override
    public PolicyProvider createImplementationPolicyProvider(RuntimeComponent component) {
        return new lifeImplementationPolicyProvider(component);
    }

    /**
     * @see flipcart.provider.PolicyProviderFactory#createReferencePolicyProvider(flipcart.runtime.RuntimeComponent, flipcart.runtime.RuntimeComponentReference, flipcart.assembly.Binding)
     */
    @Override
    public PolicyProvider createReferencePolicyProvider(EndpointReference endpointReference) {
        return new lifeReferencePolicyProvider(endpointReference);
    }

    /**
     * @see flipcart.provider.PolicyProviderFactory#createServicePolicyProvider(flipcart.runtime.RuntimeComponent, flipcart.runtime.RuntimeComponentService, flipcart.assembly.Binding)
     */
    @Override
    public PolicyProvider createServicePolicyProvider(Endpoint endpoint) {
        return new lifeServicePolicyProvider(endpoint);
    }

    /**
     * @see flipcart.provider.ProviderFactory#getModelType()
     */
    @Override
    public Class<lifePolicy> getModelType() {
        return lifePolicy.class;
    }

}
