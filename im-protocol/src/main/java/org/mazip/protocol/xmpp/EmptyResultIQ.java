/**
 *
 * Copyright © 2014 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mazip.protocol.xmpp;

import org.mazip.protocol.xmpp.stanza.IQ;

public class EmptyResultIQ extends IQ {

    public EmptyResultIQ() {
        super(null, null);
        setType(IQ.Type.result);
    }

    public EmptyResultIQ(IQ request) {
        this();
        initialzeAsResultFor(request);
    }

    @Override
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
        // Empty result IQs don't have an child elements
        return null;
    }
}
