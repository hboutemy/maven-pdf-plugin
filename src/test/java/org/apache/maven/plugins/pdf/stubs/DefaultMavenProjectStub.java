package org.apache.maven.plugins.pdf.stubs;

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

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

/**
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @version $Id$
 */
public class DefaultMavenProjectStub
    extends MavenProjectStub
{
    public DefaultMavenProjectStub()
    {
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        try
        {
            Model model = pomReader.read( new FileReader( new File( getBasedir() + "/pom_filtering.xml" ) ) );
            setModel( model );
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    /** {@inheritDoc} */
    public String getName()
    {
        return getModel().getName();
    }

    /** {@inheritDoc} */
    public String getVersion()
    {
        return getModel().getVersion();
    }

    /** {@inheritDoc} */
    public File getBasedir()
    {
        return new File( super.getBasedir() + "/target/test-classes/unit/pdf/" );
    }

    /** {@inheritDoc} */
    public List getDevelopers()
    {
        return getModel().getDevelopers();
    }

    /** {@inheritDoc} */
    public Properties getProperties()
    {
        return getModel().getProperties();
    }
}
