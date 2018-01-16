# NLS_MESSAGEFORMAT_VAR          needed to handle quotes correctly
#
# File: sqlparsermessages.properties
# Description: Properties file for classes in the SQLParser Plugin

# =============================================================================
# Copyright (c) 2000, 2005 IBM Corporation and others.
# All rights reserved. This program and the accompanying materials 
# are made available under the terms of the Eclipse Public License v1.0
# which is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#     IBM Corporation - initial API and implementation
# =============================================================================

# "token" is a technical term used in the context of parsers, might not be translated
# "terminal symbol" might be used instead or used as source for tranlation, it is the
# smallest unit in a parser input, like a keyword, identifier or a special single character
!
# Strings for SQL parser error messages

# Attention translators: mnemonics (short keys, marked with "&") can vary in translations
# message values should not use the mnemonics "reserved" for standard buttons like "Back", "Next", "Finish"

SQLParserException.GENERAL_MESSAGE=�Է� ���� ���� �м��� �� �����ϴ�: "{0}"
SQLParseErrorInfo.NO_CORRECTION_AVAILABLE = ������ �� �����ϴ�.

! "token" is a technical term, see note above
SQLParserException.LEX_ERROR_CODE 		= ����ġ ���� ���� "{0}"��(��) ���õǾ����ϴ�.
SQLParserException.ERROR_CODE 			= ��ū "{0}"���� ���� �м��� ����Ǿ����ϴ�.
SQLParserException.BEFORE_CODE			= ��ū "{1}" �տ� "{0}"�� �����߽��ϴ�.
SQLParserException.INSERTION_CODE 		= ��ū "{1}" �ڿ� "{0}"�� �ʿ��մϴ�.
SQLParserException.INVALID_CODE   		= ����ġ ���� �Է� ���� "{0}"��(��) ����߽��ϴ�.
SQLParserException.SUBSTITUTION_CODE  	= �Է� "{1}" ��� "{0}"��(��) �ʿ��մϴ�.
SQLParserException.SECONDARY_CODE 		= �Է� "{1}" ��� "{0}"��(��) �ʿ��մϴ�.
SQLParserException.DELETION_CODE  		= ����ġ ���� ��ū "{0}"��(��) �����߽��ϴ�.
SQLParserException.MERGE_CODE 			= ���յ� ��ū���� "{0}"��(��) �����Ͽ����ϴ�.
SQLParserException.MISPLACED_CODE 		= ���� "{0}"�� ��ġ�� �߸��Ǿ����ϴ�.
SQLParserException.SCOPE_CODE 			= ��ü ������ "{0}"(��)�� �����߽��ϴ�.
SQLParserException.EOF_CODE   			= ������ ���� ��ū "{0}" �ڿ� ����Ǿ� �ֽ��ϴ�.
SQLParserException.INVALID_TOKEN_CODE 	= "{0}"��(��) �߸��Ǿ����ϴ�.

! Note to translater: statement is a well known term related to the SQL language
SQLParserManager.MULTIPLE_STATEMENTS  	= ���� SQL ���� �� ���ؽ�Ʈ�� ������ �ʽ��ϴ�.

#
# following message keys not yet in use, for future release
#

DATATOOLS.PROJECT.DEV.PROP.PRESERVE_USER_FORMAT 	= ���� �ؽ�Ʈ�� ���� ����(&P)
DATATOOLS.PROJECT.DEV.PROP.ALWAYS_QUALIFY_COLUMNS   = SQL ���� �ؽ�Ʈ�� ��ȣ�� �� ���� ����(&Q)

! the following decribes that we try to be smart and figure out column references
! in the SQL source, even when not correctly specified, we correct the input then, e.g. SELECT tableA.col1 FROM schema1.tableA AS TA would be corrected to SELECT TA.col1 FROM schema1.tableA AS TA
DATATOOLS.PROJECT.DEV.PROP.SMART_RESOLVING  		= SQL ���� �ؽ�Ʈ�� �� ���� ���� �ڵ� ����(&C)