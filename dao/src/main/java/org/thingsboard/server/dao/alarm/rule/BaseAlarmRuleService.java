/**
 * Copyright © 2016-2022 The Thingsboard Authors
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
package org.thingsboard.server.dao.alarm.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thingsboard.server.common.data.alarm.rule.AlarmRule;
import org.thingsboard.server.common.data.alarm.rule.AlarmRuleInfo;
import org.thingsboard.server.common.data.id.AlarmRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.entity.AbstractEntityService;
import org.thingsboard.server.dao.service.DataValidator;

import static org.thingsboard.server.dao.service.Validator.validateId;

@Service
@Slf4j
public class BaseAlarmRuleService extends AbstractEntityService implements AlarmRuleService {

    @Autowired
    private AlarmRuleDao alarmRuleDao;

    @Autowired
    private DataValidator<AlarmRule> alarmRuleDataValidator;

    @Override
    public AlarmRule saveAlarmRule(TenantId tenantId, AlarmRule alarmRule) {
        alarmRuleDataValidator.validate(alarmRule, AlarmRule::getTenantId);
        return alarmRuleDao.save(tenantId, alarmRule);
    }

    @Override
    public void deleteAlarmRule(TenantId tenantId, AlarmRuleId alarmRuleId) {
        log.debug("Deleting AlarmRule Id: {}", alarmRuleId);
        alarmRuleDao.removeById(tenantId, alarmRuleId.getId());
    }

    @Override
    public AlarmRule findAlarmRuleById(TenantId tenantId, AlarmRuleId alarmRuleId) {
        log.trace("Executing findAlarmById [{}]", alarmRuleId);
        validateId(alarmRuleId, "Incorrect alarmRuleId " + alarmRuleId);
        return alarmRuleDao.findById(tenantId, alarmRuleId.getId());
    }

    @Override
    public PageData<AlarmRuleInfo> findAlarmInfos(TenantId tenantId, PageLink pageLink) {
        return alarmRuleDao.findAlarmInfosByTenantId(tenantId.getId(), pageLink);
    }

}
