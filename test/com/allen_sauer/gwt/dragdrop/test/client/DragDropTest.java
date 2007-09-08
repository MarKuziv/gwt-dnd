/*
 * Copyright 2007 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

import com.allen_sauer.gwt.log.client.Log;

/**
 * EntryPoint class for demonstrating and testing drag-and-drop library.
 */
public final class DragDropTest implements EntryPoint {
  private static native String getCompatMode()
  /*-{
    return $doc.compatMode;
  }-*/;

  public void onModuleLoad() {
    // set DragDropTest exception handler
    GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
      public void onUncaughtException(Throwable e) {
        Log.fatal("DragDropTest UncaughtExceptionHandler caught", e);
      }
    });

    // use deferred command to catch initialization exceptions
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        onModuleLoad2();
      }
    });
  }

  public void onModuleLoad2() {
    RootPanel.get().add(new HTML("DragDropTest is in <b>" + getCompatMode() + "</b> mode."));
  }
}
