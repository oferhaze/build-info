/*
 * Copyright (C) 2010 JFrog Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfrog.build.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * Information about the agent that triggered the build (e.g. Hudson, TeamCity etc.).
 *
 * @author Noam Y. Tenne
 */
@XStreamAlias("notifications")
public class Notifications implements Serializable {

    private String[] licenseViolationsRecipients;

    public String[] getLicenseViolationsRecipients() {
        return licenseViolationsRecipients;
    }

    public void setLicenseViolationsRecipients(String[] licenseViolationsRecipients) {
        this.licenseViolationsRecipients = licenseViolationsRecipients;
    }


    /**
     * Set the emails of recipients about license violations from a comma separated list
     *
     * @param licenseViolationsRecipients
     */
    public void setLicenseViolationsRecipientsList(String licenseViolationsRecipients) {
        String[] recipients = StringUtils.split(licenseViolationsRecipients, " ");
        setLicenseViolationsRecipients(recipients);
    }

    public String getLicenseViolationsRecipientsList() {
        StringBuilder builder = new StringBuilder();
        String[] recipients = getLicenseViolationsRecipients();
        for (String recipient : recipients) {
            builder.append(recipient).append(" ");
        }
        return builder.toString();
    }
}