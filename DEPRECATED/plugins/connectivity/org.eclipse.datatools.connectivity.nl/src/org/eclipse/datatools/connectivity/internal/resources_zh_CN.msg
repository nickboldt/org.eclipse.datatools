## Copyright (c) 2005, 2011 Sybase, Inc. and others.
## All rights reserved. This program and the accompanying materials
## are made available under the terms of the Eclipse Public License v1.0
## which accompanies this distribution, and is available at
## http://www.eclipse.org/legal/epl-v10.html
##
## Contributors:
##    Sybase, Inc. - initial API and implementation
##    IBM Corporation - migrated to new wizard framework
##    IBM Corporation - fix for defect 222818
##    Actuate Corporation - added the cipherProvider extension point [BZ 358686]
################################################################################ 
plugin.internal_error=�ڲ����� �� org.eclipse.datatools.connectivity
ConnectionProfileConstants.unknownVersion=δ֪
dialog.title.error.loadconnectionfactory = �ڡ�{0}���м������ӹ���ʱ����!
ConnectJob.name=���ڴ����� {0} �����ӡ�
ConnectJob.status.info=δ��Ϊһ��������չ������ {0} �����ӡ�
ConnectJob.status.error=δ�����ӵ� {0}��
DisconnectJob.name=���ڹر��� {0} �����ӡ�
DisconnectJob.status.info=δ��Ϊһ��������չ�ر��� {0} �����ӡ�
DisconnectJob.status.error=δ���� {0} �Ͽ����ӡ�
CreateConnectionJob.name=���� {0} �� {1}��
CreateConnectionJob.error=������ {1} �� {0} ����ʱ������������{2}��
OpenConnectionEventJob.name=���ڴ��� {0} �Ĵ������¼���
CloseManagedConnectionJob.name=���ڹرյ� {1} �� {0} ���ӡ�
CloseManagedConnectionJob.error=�رյ� {1} �� {0} ����ʱ������(����\: {2})
CloseConnectionEventJob.name=���ڴ��� {0} �Ĺر������¼���
assert.invalid.profile = ��������: ��Ч����({0})
assert.invalid.profile.duplicateFactory = ��������\: �����ظ����ȼ�({0})���ظ����� ID
assert.invalid.profile.nullFactory = ��������\: �����򹤳� id Ϊ�� ({0}/{1})
dialog.title.error.loadwizard = �ڡ�{0}���м�������ʱ����!
operation.new.connectionprofile = ���ڴ��������ļ�:��{0}��
error.connect = ���ӵ������ļ���{0}��ʱ�������⡣��鿴��־�ļ����˽����顣
marker.error = ���ӵ������ļ� {0} ʱ�������⡣(����: {1})
drivermarker.error = ��������{0}���������⡣(����\: {1})
drivermarker.import.error = ���������ļ���{0}�������д���������������ȱ�� Jar �б���
profile.duplicate =���Ӹ�Ҫ�ļ�����{0}���ظ���
profile.notexist = ���������ļ���{0}��������!
duplicate.profile.name = ���� {0}({1})
DriverConnectionBase.error.unknown=������δָ���Ĵ�������ʧ�ܡ�
DriverConnectionBase.error.driverDefinitionNotSpecified=δָ�����������塣
DriverConnectionBase.error.driverDefinitionNotFound=�Ҳ������������塣
error.loadprofilesxml = �������������ļ�����ʱ������
error.saveprofilesxml = �������������ļ�����ʱ������
error.loaddriversxml = ������������������ʱ������
error.savedriversxml = ������������������ʱ������

trace.error.propertiesPersistenceHook = �޷����� propertiesPersistenceHook��ʹ��Ĭ��ֵ(�����ļ�����Ϊ {0}����չΪ {1})
trace.error.propertiesPersistenceHookSaveError = �������������쳣��֧ʱ������������������(�����ļ�Ϊ {0}����չΪ {1})
trace.error.propertiesPersistenceHookLoadError = �������������쳣��֧ʱ������δ������������(�����ļ�Ϊ {0}����չΪ {1})
trace.error.migration = Ϊ���������ļ��ṩ�������Ǩ��Ԫ��ʱ����(id={0}��Ǩ����={1})
trace.error.drivermigration = ���������ļ�(id={0}���������� id={1})����������ʵ��ʱ����

migration.error.providerDoesNotExist = ����Ǩ��Ԫ��ʱ����: ָ���� newProviderID ��Ч(newProviderID={0})
migration.error.invalidPropertyMigrationElement = ����Ǩ��Ԫ��ʱ����: propertyMigration ����ָ�� newPropertyKey��oldPropertyKey �����
migration.error.unknownParentElement = ����Ǩ��Ԫ��ʱ����: δ֪��Ԫ��(��Ԫ������={0})

DriverUtil.taskName = ���ڴ��� {0} �е���

Category.Name.Unknown=��֧��

WorkOfflineJob.name = �� {0} ����Ϊ�ѻ�����ģʽ��
WorkOfflineJob.status.error = �޷�Ϊһ��������չ������ {1} ���ѻ����ӡ�

SaveWorkOfflineDataJob.name = ���� {0} ���ѻ����ݡ�
SaveWorkOfflineDataJob.status = �����ѻ�����״̬��

CreateOfflineConnectionJob.name = ������ {1} ���ѻ� {0} ���ӡ�
CreateOfflineConnectionJob.error = ������ {1} ���ѻ� {0} ����ʱ������(����: {2})

ManagedConnection_save_not_connected_error = �������ӵ����������ܱ����ѻ����ݡ�
ManagedConnection_offline_not_supported_error = {0} ��֧���ѻ�������

drivers.error.finding.property.no.template = ���Դ���������ģ���м��� {0} ʱ�������⡣

JDBCConnection.technologyName = JDBC
JDBCConnection.invalidDriverDefinition = {0}\: {1}. ʹ�����ݿ������ļ��ж���������������ԡ�

error.database.not.start = δ�����������ݿ���� ErrorCode = {0}��SQLState = {1}��
PluginResourceLocator.invalidURL = ��Ч URL {0} (����\: {1})
ConnectivityPlugin.error.noDefaultWorkspace = �޷�ȷ��Ĭ�Ϲ�����λ�á�  ��������� OSGi ƽ̨���û����ݹ��߹�����·����
CipherProviderExtensions.missingRequiredAttrValue = {2} �ṩ�� {1} ��չ�е� {0} Ԫ��ȱ��һ��������������ֵ: {3}={4}, {5}={6}
CipherProviderExtensions.invalidClassAttrValue = {2} �ṩ�� {1} ��չ�е������� {0} ��Ч��  ������ʵ�� {3} Java �ӿڡ�
CipherProviderExtensions.conflictingExtensions = ע��� ICipherProvider ({0})���滻Ϊ {2} �е���һ����չΪ��ͬ�ļ���չ��({3})�ṩ�� ICipherProvider ({1})��

