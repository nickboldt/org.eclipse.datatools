# NLS_MESSAGEFORMAT_VAR          needed to handle quotes correctly
#
# File: sqlqueryparsermessage.properties
# Description: Properties file for classes in the SQLQueryParser Plugin

# ==============================================================================
# Copyright (c) 2004, 2005 IBM Corporation and others.
# All rights reserved. This program and the accompanying materials 
# are made available under the terms of the Eclipse Public License v1.0
# which is available at
# http://www.eclipse.org/legal/epl-v10.html
# ==============================================================================

DataTypeResolver.DATA_TYPE_UNDETERMINED 		= ����ȷ����{0}�����������͡�
DataTypeResolver.VARIABLE_TYPE_UNDETERMINED 	= ����ȷ��������{0}�����������͡�
DataTypeResolver.DATA_TYPES_INCOMPATIBLE		= ��{0}���͡�{1}�����������Ͳ����ݡ�

TableReferenceResolver.SCHEMAS_NOT_LOADED   	= �Ҳ������ݿ�ܹ���������ݿ����ӡ�{0}����
TableReferenceResolver.UNRESOLVED_COLUMN		= �Ҳ����С�{0}���ı���
TableReferenceResolver.UNRESOLVED_TABLE			= �Ҳ�������{0}����
TableReferenceResolver.TABLE_HAS_NO_SUCH_COLUMN	= ����{0}��δ�����С�{1}����
TableReferenceResolver.AMBIGUOUS_COLUMN			= ������{0}�������塣
TableReferenceResolver.AMBIGUOUS_TABLE			= ������{0}�������塣
TableReferenceResolver.AMBIGUOUS_TABLE_ALIAS	= ��������{0}�������塣

RoutineReferenceResolver.UNRESOLVED_PROC        = �޷��ҵ����̡�
RoutineReferenceResolver.INCORRECT_PARM_COUNT	= ��������������ȷ��

#
# following messages to translate names of syntax rules that were violated and caused parser error
# fill-ins - no sentences! first letter should be lower case if not a KEYWORD
#
! uppercase words are keywords and not to be translated
! "predicate" is a SQL language term equivalent to the word "test"
! "term", "factor" are closely related to mathematical terms "term" and "factor"
SQLQueryParser.<alias_name> 					= ����
SQLQueryParser.<all_or_any_cond>		 		= �����Ƚ�
SQLQueryParser.<as_alias> 						= AS ����
SQLQueryParser.<boolean_expression>				= ����ֵ����ʽ
SQLQueryParser.<boolean_factor> 				= ��������
SQLQueryParser.<boolean_primary> 				= ��������
SQLQueryParser.<boolean_term> 					= ������
SQLQueryParser.<boolean_values> 				= ��ʵֵ
SQLQueryParser.<case_expression> 				= CASE ����ʽ
SQLQueryParser.<case_search_when> 				= WHEN-THEN ����
SQLQueryParser.<case_search_when_list> 			= WHEN-THEN �����б�
SQLQueryParser.<case_simple_when> 				= WHEN-THEN ����ʽ
SQLQueryParser.<case_simple_when_list>	 		= WHEN-THEN ����ʽ�б�
SQLQueryParser.<cast_expression> 				= CAST ����ʽ
SQLQueryParser.<column> 						= ��
SQLQueryParser.<column_name> 					= ������
SQLQueryParser.<column_name_list> 				= �������б�
SQLQueryParser.<column_ref> 					= ������
SQLQueryParser.<condition> 						= ����
SQLQueryParser.<constant> 						= ��ֵ
SQLQueryParser.<datatype> 						= ��������
SQLQueryParser.<datatype_array_type> 			= ARRAY ��������
SQLQueryParser.<datatype_binary> 				= ��������������
SQLQueryParser.<datatype_predefined>			= Ԥ������������
SQLQueryParser.<datatype_character> 			= �ַ���������
SQLQueryParser.<datatype_character_national>	= ���һ�����ַ���������
SQLQueryParser.<datatype_collection_type> 		= ������������
SQLQueryParser.<datatype_date> 					= ������������
SQLQueryParser.<datatype_multiset_type> 		= MULTISET ��������
SQLQueryParser.<datatype_numerical> 			= ������������
SQLQueryParser.<datatype_numerical_approximate>	= ����������������
SQLQueryParser.<datatype_numerical_exact> 		= ��ȷ������������
SQLQueryParser.<datatype_numerical_fixed_precision>	= �̶�����������������
SQLQueryParser.<datatype_numerical_integer> 	= ������������
SQLQueryParser.<datatype_opt_size_unit> 		= �������ͳ��ȳ���(K��M �� G)
SQLQueryParser.<datatype_time> 					= ʱ����������
SQLQueryParser.<datatype_user_defined_distinct>	= ��ֵ�û�������������
SQLQueryParser.<delete_stmt> 					= DELETE ���
SQLQueryParser.<duration> 						= ����ʱ��
SQLQueryParser.<exists> 						= EXISTS ν��
SQLQueryParser.<expression> 					= ֵ����ʽ
SQLQueryParser.<expression_commalist> 			= �ö��Ÿ�����ֵ����ʽ�б�
SQLQueryParser.<expression_commalist_multiple_elements>	= �ö��Ÿ�����ֵ����ʽ�б������Ԫ�أ�
SQLQueryParser.<expression_factor> 				= ֵ����ʽ����
SQLQueryParser.<expression_term>		 		= ֵ����ʽ��
SQLQueryParser.<func_ref> 						= ��������
SQLQueryParser.<function> 						= ����
SQLQueryParser.<grouping> 						= GROUP BY �Ӿ�
SQLQueryParser.<grouping_exp> 					= �������ʽ
SQLQueryParser.<grouping_sets> 					= GROUPING SETS
SQLQueryParser.<grouping_sets_element> 			= GROUPING SETS Ԫ��
SQLQueryParser.<grouping_sets_element_exp> 		= GROUPING SETS Ԫ�ر���ʽ
SQLQueryParser.<grouping_sets_element_exp_list>	= GROUPING SETS Ԫ�ر���ʽ�б�
SQLQueryParser.<grouping_sets_element_list> 	= GROUPING SETS Ԫ���б�
SQLQueryParser.<grouping_spec> 					= GROUP BY �淶
SQLQueryParser.<grouping_spec_list> 			= GROUP BY �淶�б�
SQLQueryParser.<identifier> 					= ��ʶ��
SQLQueryParser.<in_cond> 						= IN ν��
SQLQueryParser.<insert_row> 					= ������
SQLQueryParser.<insert_row_commalist> 			= �ö��Ÿ����Ĳ������б�
SQLQueryParser.<insert_stmt> 					= INSERT ���
SQLQueryParser.<intervaltest> 					= BETWEEN ν��
SQLQueryParser.<liketest> 						= LIKE ν��
! "predicate" here could also be "test" 
SQLQueryParser.<nulltest> 						= NULL ν��
SQLQueryParser.<opt_all_distinct> 				= ALL �� DISTINCT
SQLQueryParser.<opt_as> 						= ��ѡ AS
SQLQueryParser.<opt_as_alias> 					= ��ѡ AS ����
SQLQueryParser.<opt_as_target_table> 			= ��ѡ AS Ŀ���
SQLQueryParser.<opt_asc_desc> 					= ��ѡ ASC �� DESC
SQLQueryParser.<opt_case_else> 					= ��ѡ ELSE CASE
SQLQueryParser.<opt_column_name_list> 			= ��ѡ�������б�
SQLQueryParser.<opt_escape> 					= ��ѡ ESCAPE ����ʽ
SQLQueryParser.<opt_expression_commalist> 		= �ö��Ÿ����Ŀ�ѡֵ����ʽ�б�
SQLQueryParser.<opt_group_by_clause> 			= ��ѡ GROUP BY �Ӿ�
SQLQueryParser.<opt_having_clause> 				= ��ѡ HAVING �Ӿ�
SQLQueryParser.<opt_join_type> 					= ��ѡ JOIN ����
SQLQueryParser.<opt_join_type_outer> 			= ��ѡ OUTER
SQLQueryParser.<opt_order_by_clause> 			= ��ѡ ORDER BY �Ӿ�
! "Schema" is a database related term
SQLQueryParser.<opt_schema_dot> 				= ��ѡ�ܹ��޶���
! "table" is a database related term
SQLQueryParser.<opt_table_correlation> 			= ��ѡ������
SQLQueryParser.<opt_target_column_list> 		= ��ѡĿ�����б�
SQLQueryParser.<opt_where_clause> 				= ��ѡ WHERE �Ӿ�
SQLQueryParser.<ordering_spec> 					= ����淶
SQLQueryParser.<ordering_spec_commalist> 		= �ö��Ÿ���������淶�б�
SQLQueryParser.<parameter> 						= ����
SQLQueryParser.<project> 						= ѡ��
SQLQueryParser.<query_combined> 				= ��ϲ�ѯ
SQLQueryParser.<query_combined_operator>		= ��ϲ�ѯ����� UNION��EXCEPT �� INTERSECT
SQLQueryParser.<query_exp>						= ��ѯ����ʽ
SQLQueryParser.<query_exp_root>					= ��ѯ����ʽ
SQLQueryParser.<query_select>					= SELECT ��ѯ
SQLQueryParser.<query_stmt>						= SQL ��ѯ���
SQLQueryParser.<query_term>						= ��ѯ��
SQLQueryParser.<query_values>					= VALUES �����캯��
SQLQueryParser.<relop>							= ��ϵ�����
SQLQueryParser.<scalcomp>						= �����Ƚ�
SQLQueryParser.<schema>							= �ܹ�
SQLQueryParser.<selection>						= ѡ��
SQLQueryParser.<simplecomp>						= �򵥱Ƚ�
SQLQueryParser.<special_register>				= ר�üĴ���
SQLQueryParser.<sql_dml_stmt>					= SQL DML ���
SQLQueryParser.<sql_dml_stmt_list>				= SQL DML ����б�
SQLQueryParser.<sql_dml_stmt_xspan>				= SQL DML ����б�
SQLQueryParser.<subquery>						= �Ӳ�ѯ
SQLQueryParser.<super_groups>					= CUBE �� ROLLUP ����
SQLQueryParser.<super_groups_element>			= �������ʽ
SQLQueryParser.<super_groups_element_exp>		= �������ʽ
SQLQueryParser.<super_groups_element_exp_list>	= �������ʽ�б�
SQLQueryParser.<super_groups_element_list>		= �������ʽ�б�
SQLQueryParser.<table>							= ��
SQLQueryParser.<table_correlation>				= ������
SQLQueryParser.<table_join>						= ���ӵı�
SQLQueryParser.<table_name_or_alias> 			= �����������
SQLQueryParser.<table_query>					= Ƕ�ױ���ѯ
SQLQueryParser.<table_ref>						= ������
SQLQueryParser.<table_ref_commalist>			= �ö��Ÿ����ı������б�
SQLQueryParser.<target_column_list>				= Ŀ�����б�
SQLQueryParser.<target_table>					= Ŀ���
SQLQueryParser.<update_assignment_clause>		= UPDATE ָ���Ӿ�
SQLQueryParser.<update_assignment_expression>	= UPDATE ָ������ʽ
SQLQueryParser.<update_assignment_expression_commalist>	= �ö��Ÿ����ĸ���ָ������ʽ�б�
SQLQueryParser.<update_stmt>					= UPDATE ���
SQLQueryParser.<values_row>						= ֵ��
SQLQueryParser.<values_row>						= ֵ��
SQLQueryParser.<values_row_commalist>			= �ö��Ÿ�����ֵ���б�
SQLQueryParser.<with_clause>					= WITH �Ӿ�
SQLQueryParser.<with_table_spec>				= WITH ���淶
SQLQueryParser.<with_table_spec_list>			= WITH ���淶�б�



SQLQueryDB2Parser.<olap_aggregation_function>	= OLAP �ۺϺ���
SQLQueryDB2Parser.<olap_current_row>			= CURRENT ROW
SQLQueryDB2Parser.<olap_function>				= OLAP ����
SQLQueryDB2Parser.<olap_group_end>				= FOLLOWING ����ʽ
SQLQueryDB2Parser.<olap_group_start>			= PRECEDING ����ʽ
SQLQueryDB2Parser.<olap_group_type>				= OLAP ��������
SQLQueryDB2Parser.<olap_numbering_function>		= OLAP ��ź���
SQLQueryDB2Parser.<olap_order_by_expression>	= OLAP ORDER BY ����ʽ
SQLQueryDB2Parser.<olap_order_by_list>			= OLAP ORDER BY ����ʽ�б�
SQLQueryDB2Parser.<olap_partitioning_expression_list>	= OLAP ��������ʽ�б�
SQLQueryDB2Parser.<olap_partitioning_expression>		= OLAP ��������ʽ
SQLQueryDB2Parser.<olap_rank_or_dense_rank>				= RANK() �� DENSE_RANK()
SQLQueryDB2Parser.<olap_ranking_function>				= OLAP ��������
SQLQueryDB2Parser.<olap_rows_or_range>					= ROWS �� RANGE
SQLQueryDB2Parser.<olap_window_order_clause>			= OLAP ���������Ӿ�
SQLQueryDB2Parser.<opt_olap_asc_desc>					= OLAP ASC/DESC �淶
SQLQueryDB2Parser.<opt_olap_window_aggregation_group>	= ��ѡ OLAP ���ھۺ���
SQLQueryDB2Parser.<opt_olap_window_order_agregration_group>	= ��ѡ OLAP ��������ۺ���
SQLQueryDB2Parser.<opt_olap_window_order_clause>			= ��ѡ OLAP ���������Ӿ�
SQLQueryDB2Parser.<opt_olap_window_parition_clause>			= ��ѡ OLAP ���ڷ����Ӿ�

SQLQueryDB2Parser.<opt_xml_element_attributes_function>		= ��ѡ XMLATTRIBUTES ����
SQLQueryDB2Parser.<opt_xml_element_content_list>			= ��ѡ XML Ԫ�����ݱ���ʽ�б�
SQLQueryDB2Parser.<opt_xml_element_namespaces_function>		= ��ѡ XMLNAMESPACES ����
SQLQueryDB2Parser.<opt_xml_forest_namespaces_function>		= ��ѡ XMLNAMESPACES ����
SQLQueryDB2Parser.<xml_agg_function>			= XMLAGG ����
SQLQueryDB2Parser.<xml_attribute_list>			= XML ���Ա���ʽ�б�
SQLQueryDB2Parser.<xml_attribute>				= XML ���Ա���ʽ
SQLQueryDB2Parser.<xml_attributes_function>		= XMLATTRIBUTES ����
SQLQueryDB2Parser.<xml_concat_function>			= XMLCONCAT ����
SQLQueryDB2Parser.<xml_element_content_list>	= ��ѡ XML Ԫ�����ݱ���ʽ
SQLQueryDB2Parser.<xml_element_content>			= XML Ԫ�����ݱ���ʽ
SQLQueryDB2Parser.<xml_element_function>		= XMLELEMENT ����
SQLQueryDB2Parser.<xml_forest_element_list>		= XML ɭ��Ԫ���б�
SQLQueryDB2Parser.<xml_forest_element>			= XMLFOREST Ԫ�ر���ʽ
SQLQueryDB2Parser.<xml_forest_function>			= XMLFOREST ���� XMLSERIALIZE �� XML2CLOB
SQLQueryDB2Parser.<xml_function>				= XML ���� 
SQLQueryDB2Parser.<xml_namespace_list>			= XML ���ƿռ��б�
SQLQueryDB2Parser.<xml_namespace_prefix>		= XML ���ƿռ�ǰ׺
SQLQueryDB2Parser.<xml_namespace_uri>			= XML ���ƿռ� URI
SQLQueryDB2Parser.<xml_namespace>				= XML ���ƿռ�
SQLQueryDB2Parser.<xml_namespaces_function>		= XMLNAMESPACES ����
SQLQueryDB2Parser.<xml_value_datatype>			= XML ֵ��������
SQLQueryDB2Parser.<xml_value_function_list>		= XML ֵ�����б�
SQLQueryDB2Parser.<xml_value_function>			= XML ֵ����

