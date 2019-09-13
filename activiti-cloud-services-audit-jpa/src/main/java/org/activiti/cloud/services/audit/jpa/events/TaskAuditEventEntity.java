package org.activiti.cloud.services.audit.jpa.events;

import org.activiti.api.task.model.Task;
import org.activiti.cloud.api.task.model.events.CloudTaskRuntimeEvent;
import org.activiti.cloud.services.audit.jpa.converters.json.TaskJpaJsonConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TaskAuditEventEntity extends AuditEventEntity {

    @Convert(converter = TaskJpaJsonConverter.class)
    @Lob
    @Column
    private Task task;

    private String taskId;

    private String taskName;

    public TaskAuditEventEntity() {
    }

    public TaskAuditEventEntity(CloudTaskRuntimeEvent cloudEvent) {
        super(cloudEvent);
        setTask(cloudEvent.getEntity());
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
        if (task != null) {
            this.taskId = task.getId();
            this.taskName = task.getName();
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
