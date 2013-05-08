/*
 * Copyright (c) 2013 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Amos SS13 Project - Productive Games Development (PGA) application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * Software Developers in alphabetical order:
 * Nina Aures
 * Alexander Schmidt
 * Sascha Stroebel
 */

package de.osramos.ss13;

//import org.apache.wicket.markup.html.form.Form;
//import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.model.PropertyModel;
//import org.apache.wicket.request.mapper.parameter.PageParameters;
//import org.apache.wicket.util.value.ValueMap;
//import org.apache.wicket.markup.html.basic.Label;
//import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.util.value.ValueMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ClientSideImageMap;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.pages.RedirectPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.parser.filter.RelativePathPrefixHandler;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.time.Duration;

import de.osramos.ss13.RegistrationPage.RegisterForm;

public class TraineeTaskPage extends WebPage {
	private static final long serialVersionUID = 1L;

	//private String taskname;

	public TraineeTaskPage(final PageParameters parameters) {
		// TODO Add your page's components here

		//PropertyModel<String> tasknameModel = new PropertyModel<String>(this,"taskname");
		//add(new Label("lasttaskname", tasknameModel));

		//Form<?> form = new Form("form");
		//form.add(new TextField<String>("taskname", tasknameModel));
		//add(form);

		add(new TraineeTaskPageForm("form"));
	}
	
	
	public final class TraineeTaskPageForm extends Form<Void>
    {
		private final ValueMap properties = new ValueMap();
		
		public TraineeTaskPageForm(String id) {
			super(id);
			// TODO Auto-generated constructor stub
			
			add(new TextField<String>("taskname", new PropertyModel<String>(properties, "taskname")));
		}

		@Override
	    public final void onSubmit()
	    {
	        TaskDB t = new TaskDB();
	        t.setTaskname(properties.getString("taskname"));
	        //t.setTaskname("taskname123");
	        t.setDescription("desc");
	        HibernateTools.save(t);
			
//			UserDB user = new UserDB();
//            user.setFirstname("!!!!");
//            user.setLastname("!!!!");
//            user.setUsername("!!!!");
//            user.setPassword("!!!!");
//            HibernateTools.save(user);
	    }
    }

}