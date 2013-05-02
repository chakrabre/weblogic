/**
 * 
 */
package org.jenkinsci.plugins.deploy.weblogic.data;

import org.codehaus.plexus.util.StringUtils;

/**
 * @author Raphael
 *
 */
public class DeploymentTaskResult {

	private WebLogicDeploymentStatus status;
	
	private DeploymentTask task;
	
	private String resourceName;
	
	/**
	 * 
	 * @param status
	 * @param environment
	 */
	public DeploymentTaskResult(WebLogicDeploymentStatus status, DeploymentTask task, String resourceName) {
		this.task = task;
		this.status = status;
		this.resourceName = resourceName;
	}

	/**
	 * @return the task result label
	 */
	public String getLabel() {
		String actionLabel = "";
		
		if(StringUtils.isNotBlank(this.getResourceName())) {
			actionLabel = this.getResourceName();
		} else if(StringUtils.isNotBlank(this.getTask().getTaskName())) {
			actionLabel = this.getTask().getTaskName();
		} else {
			actionLabel = this.getTask().getId();
		}
		
		return StringUtils.defaultString(actionLabel,"").concat("#").concat(StringUtils.defaultString(this.getTask().getWeblogicEnvironmentTargetedName(),""));
	}
	
	/**
	 * @return the status
	 */
	public WebLogicDeploymentStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(WebLogicDeploymentStatus status) {
		this.status = status;
	}

	/**
	 * @return the task
	 */
	public DeploymentTask getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(DeploymentTask task) {
		this.task = task;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}