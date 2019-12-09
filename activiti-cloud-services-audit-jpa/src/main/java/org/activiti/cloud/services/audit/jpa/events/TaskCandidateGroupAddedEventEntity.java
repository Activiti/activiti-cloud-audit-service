/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.services.audit.jpa.events;

import org.activiti.api.task.model.TaskCandidateGroup;
import org.activiti.api.task.model.impl.TaskCandidateGroupImpl;
import org.activiti.cloud.api.task.model.events.CloudTaskCandidateGroupAddedEvent;
import org.activiti.cloud.services.audit.jpa.converters.json.TaskCandidateGroupJpaJsonConverter;
import org.hibernate.annotations.Type;

import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.util.Objects;

@Entity(name = TaskCandidateGroupAddedEventEntity.TASK_CANDIDATE_GROUP_ADDED_EVENT)
@DiscriminatorValue(value = TaskCandidateGroupAddedEventEntity.TASK_CANDIDATE_GROUP_ADDED_EVENT)
public class TaskCandidateGroupAddedEventEntity extends AuditEventEntity {

    protected static final String TASK_CANDIDATE_GROUP_ADDED_EVENT = "TaskCandidateGroupAddedEvent";

    @Convert(converter = TaskCandidateGroupJpaJsonConverter.class)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private TaskCandidateGroupImpl candidateGroup;

    public TaskCandidateGroupAddedEventEntity() {
    }

    public TaskCandidateGroupAddedEventEntity(CloudTaskCandidateGroupAddedEvent cloudEvent) {
        super(cloudEvent);
        setCandidateGroup(cloudEvent.getEntity());
    }

    public TaskCandidateGroup getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(TaskCandidateGroup candidateGroup) {
        this.candidateGroup = new TaskCandidateGroupImpl(candidateGroup.getGroupId(), candidateGroup.getTaskId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(candidateGroup);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TaskCandidateGroupAddedEventEntity other = (TaskCandidateGroupAddedEventEntity) obj;
        return Objects.equals(candidateGroup, other.candidateGroup);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TaskCandidateGroupAddedEventEntity [candidateGroup=")
               .append(candidateGroup)
               .append(", toString()=")
               .append(super.toString())
               .append("]");
        return builder.toString();
    }

}
