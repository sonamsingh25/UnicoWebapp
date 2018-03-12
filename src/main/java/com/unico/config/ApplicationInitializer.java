/**
 * 
 */
package main.java.com.unico.config;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import main.java.com.unico.config.ApplicationConfig;
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {
 protected Class < ? > [] getRootConfigClasses() {
  return new Class[] {
   ApplicationConfig.class
  };
 }
 protected Class < ? > [] getServletConfigClasses() {
  return null;
 }
 protected String[] getServletMappings() {
  return new String[] {
   "/rest/*"
  };
 }
}