###############################################################################
# Copyright (c) 2001, 2008 IBM Corporation and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#     IBM Corporation - initial API and implementation
###############################################################################
##
###
##  !!! This property file should only contain resources that are "translatable" !!!
###
##

DATATOOLS.CORE.UI.TEST = Test

#
## Add Action
#
DATATOOLS.CORE.UI.NEW.COLUMN_NAME = Colonne 
DATATOOLS.CORE.UI.NEW.SCHEMA_NAME = Sch�ma
DATATOOLS.CORE.UI.NEW.TABLE_NAME = Table
DATATOOLS.CORE.UI.NEW.TRIGGER_NAME = D�clencheur
DATATOOLS.CORE.UI.NEW.DOMAIN_NAME = Domaine
DATATOOLS.CORE.UI.NEW.SEQUENCE_NAME = S�quence
DATATOOLS.CORE.UI.NEW.STORED_PROCEDURE_NAME = Proc�dure_stock�e
DATATOOLS.CORE.UI.NEW.DATABASE = Nouvelle base de donn�es

#
## Label Decorations
#
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.DECORATION = Param�tres du d�corateur de donn�es :
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.TAB = Texte
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.FORMAT = Sp�cifier le format d'affichage pour les colonnes dans l'explorateur :
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.CFORMAT = Format de &colonne :
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.VARIABLE = Ajouter des &variables...
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.EXAMPLE = &Exemple :
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.TITLE = Ajouter des variables
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.MESSAGE = S�lectionner les variables � ajouter au format de d�coration :
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.DATATYPE_DESC = {datatype} - type de donn�es de colonne
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.NULLABLE_DESC = {nullable} - indique que la colonne est annulable
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.PK_DESC = {primaryKey} - indique que la colonne appartient � la contrainte de cl� principale
DATATOOLS.CORE.UI.PREFERENCES.COLUMN.FK_DESC = {foreignKey} - indique que la colonne appartient � la contrainte de cl� �trang�re

DATATOOLS.CORE.UI.STATUS.CONNECTION = {0} - Connexion "{1}"
DATATOOLS.CORE.UI.STATUS.PROJECT = {0} - Projet "{1}"

#
## Model Explorer Strings
#
DATATOOLS.CORE.UI.EXPLORER.DEPENDENCY=D�pendance externe

#
## Commands
#
DATATOOLS.CORE.UI.COMMAND.RENAMING = Attribution d'un nouveau nom
DATATOOLS.CORE.UI.COMMAND.ADD_DATABASE = Ajouter une base de donn�es
DATATOOLS.CORE.UI.COMMAND.ADD_FOREIGN_KEY_INDEX= Ajouter un index de cl�s �trang�res
DATATOOLS.CORE.UI.COMMAND.ADD_PRIMARY_KEY_INDEX= Ajouter un index de cl�s principales
DATATOOLS.CORE.UI.COMMAND.ADD_SEQUENCE= Ajouter une s�quence
DATATOOLS.CORE.UI.COMMAND.ADD_INDEX = Ajouter un index
DATATOOLS.CORE.UI.COMMAND.ADD_CHECK_CONSTRAINT = Ajouter une contrainte de v�rification
DATATOOLS.CORE.UI.COMMAND.ADD_ALIAS = Ajouter un pseudo
DATATOOLS.CORE.UI.COMMAND.ADD_UNIQUE_CONSTRAINT = Ajouter une contrainte unique

#
## Explorer Description
#
DATATOOLS.CORE.UI.EXPLORER.MULTI_SELECTION= {0} �l�ments s�lectionn�s

#
## DnD Actions
#
DATATOOLS.CORE.UI.DND.MOVE = D�placer
DATATOOLS.CORE.UI.DND.COPY = Copier
DATATOOLS.CORE.UI.DND.LINK = Lien

#
## Quick Fix
#
DATATOOLS.CORE.UI.QUICKFIX.ADD_DANGLING = Ajouter une r�f�rence pendante au mod�le
DATATOOLS.CORE.UI.QUICKFIX.REMOVE_DANGLING = Supprimer une r�f�rence pendante du mod�le

#
## FE Action
#
GENERATE_DDL_MENU_TEXT = G�n�rer &DDL...

#
## FE and RE Wizards
#
FE_WIZARD_TITLEBAR_TEXT = G�n�rer un DDL
FE_WELCOME_PAGE_TITLE_TEXT = Bienvenue dans l'assistant d'ing�nierie directe 
FE_WELCOME_PAGE_DESCRIPTION_TEXT = Cet assistant vous aide � g�n�rer\nun script DDL � partir d'un mod�le de donn�es. Vous pourrez enregistrer\nle script et aurez la possibilit� de l'ex�cuter sur une\nbase de donn�es.\r\n \r\n  ...pour continuer, cliquez sur Suivant... 
FE_COMPLETION_PAGE_TITLE_TEXT = Fin de l'assistant d'ing�nierie directe 
FE_COMPLETION_PAGE_DESCRIPTION_TEXT = Vous avez termin� l'assistant d'ing�nierie directe avec succ�s. 
FE_SELECT_OPTIONS_PAGE_HEADER_TITLE	= S�lectionner des �l�ments du mod�le 
FE_SELECT_OPTIONS_PAGE_HEADER_SUBTITLE = S�lectionner les �l�ments du mod�le que vous souhaitez g�n�rer dans un script DDL. 
FE_SELECT_DATABASE_PAGE_HEADER_TITLE = Enregistrer et ex�cuter le DDL 
FE_SELECT_DATABASE_PAGE_HEADER_SUBTITLE = Sp�cifier un chemin d'acc�s pour enregistrer le script DDL g�n�r�.  Vous pouvez ex�cuter le script DDL en fournissant les informations de connexion � votre base de donn�es. 
FE_PROGRESS_BAR_PAGE_HEADER_TITLE = G�n�ration d'un DDL 
FE_PROGRESS_BAR_PAGE_HEADER_SUBTITLE = Veuillez patienter le temps que le processus d'ing�nierie directe se termine. 
COMPLETION_PAGE_TITLE_FONT = Verdana
GENERATE_NO_MNEMONIC_LABEL_TEXT	= G�n�rer : 
DROP_STATEMENTS_CHECKBOX_TEXT = Instructions &Drop 
TABLES_CHECKBOX_TEXT = &Tables 
TRIGGERS_CHECKBOX_TEXT_2 = D�clencheu&rs 
FULLY_QUALIFIED_NAMES_CHECKBOX_TEXT	= Noms pleinement quali&fi�s 
COMMENTS_CHECKBOX_TEXT = &Commentaires 
VIEWS_CHECKBOX_TEXT = &Vues 
QUOTED_IDENTIFIERS_CHECKBOX_TEXT = Ide&ntificateurs entre guillemets 
INDEXES_CHECKBOX_TEXT = &Index 
TRIGGERS_CHECKBOX_TEXT=	&D�clencheurs
STORED_PROCEDURES_CHECKBOX_TEXT	= Proc�dures &stock�es
TABLESPACES_CHECKBOX_TEXT = Espaces t&ables
FILE_PATH_LABEL_TEXT = Nom de &fichier :
BROWSE_BUTTON_TEXT_2 = Parc&ourir... 
EXECUTE_CHECKBOX_TEXT =	Ex�cute&r 
FORWARD_SLASH_SQL_DELIMITER_CHECKBOX_TEXT = &Utiliser '/' comme d�limiteur d'instruction SQL 
DEFAULT_FILE_EXTENSION = .ddl
FILE_FILTER_SCRIPT_FILES = *.ddl;*.sql
FILE_FILTER_ALL_FILES =	*.*
FILE_FILTER_NAME_SCRIPT_FILES =	Fichiers de scripts (*.ddl;*.sql)
FILE_FILTER_NAME_ALL_FILES = Tous les fichiers (*.*)

#
## SQL View Menu
#
DATATOOLS.CORE.UI.SQLVIEW.LINK=Lien avec l'�diteur
DATATOOLS.CORE.UI.SQLVIEW.GENERATE=G�n�rer un SQL � partir de l'�diteur

#
## Bookmark
#
DATATOOLS.PROJECT.UI.BOOKMARK.TITLE=Ajouter un signet
DATATOOLS.PROJECT.UI.BOOKMARK.MESSAGE=Entrer un nom de signet :

#
## Inactive Relationship
#
DATATOOLS.PROJECT.UI.INACTIVE_RELATIONSHIP = Implicite

#
## Filtering Decoration
#
DATATOOLS.SERVER.UI.EXPLORER.FILTER_DECORATION = [Filtr�]

#
## Catalog Util
#
DATATOOLS.CORE.UI.LOADING=Chargement

DATATOOLS.CORE.UI.DIALOGS.FILTERLISTSELECTIONDIALOG.MESSAGE=S�lectionner des �l�ments :
DATATOOLS.CORE.UI.DIALOGS.FILTERLISTSELECTIONDIALOG.TITLE=S�lectionner des �l�ments
DATATOOLS.CORE.UI.DIALOGS.FILTERLISTSELECTIONDIALOG.FILTERLABEL=Appliquer un filtre au nom (?= Tout caract�re, * = Toute cha�ne)

#
## Output Preferences
#
DATATOOLS.CORE.UI.PREFERENCES.OUTPUT.DESCRIPTION = Vous pouvez sp�cifier des pr�f�rences pour les ensembles de r�sultats renvoy�s.
DATATOOLS.CORE.UI.PREFERENCES.OUTPUT.LIMIT_ROWS_RETRIEVED = Nombre maximum de &lignes r�cup�r�es
DATATOOLS.CORE.UI.PREFERENCES.OUTPUT.MAX_ROW_RETRIEVED = Nombre maximum de lignes � &r�cup�rer :
DATATOOLS.CORE.UI.PREFERENCES.OUTPUT.MAX_LOB_LENGTH = Nombre &maximum d'octets � r�cup�rer pour la colonne binaire ou caract�re :
DATATOOLS.CORE.UI.PREFERENCES.OUTPUT.ERROR_INVALID_INT = Sp�cifier une valeur comprise entre {0} et {1}.

#
## Index and Trigger Decorations
#
DATATOOLS.CORE.UI.INDEX_UNIQUE.DECORATION = UNIQUE
DATATOOLS.CORE.UI.TRIGGER_UPDATE.DECORATION = UPDATE
DATATOOLS.CORE.UI.TRIGGER_DELETE.DECORATION = DELETE
DATATOOLS.CORE.UI.TRIGGER_INSERT.DECORATION = INSERT
DATATOOLS.CORE.UI.TRIGGER_BEFORE.DECORATION = BEFORE
DATATOOLS.CORE.UI.TRIGGER_AFTER.DECORATION = AFTER
DATATOOLS.CORE.UI.TRIGGER_INSTEADOF.DECORATION = INSTEAD OF

#
## Resource Chooser Dialog
#
_UI_TITLE_FILE_CHOOSER = S�lection de fichier
_UI_TITLE_FOLDER_CHOOSER = S�lection de dossier
_UI_DESCRIPTION_FILE = Entrer ou s�lectionner un fichier :
_UI_DESCRIPTION_FOLDER = Entrer ou s�lectionner le dossier parent :
_UI_DEFAULT_MSG_NEW_ALLOWED = &Entrer ou s�lectionner le dossier parent :
_UI_DEFAULT_MSG_SELECT_ONLY = S�lectionner le dossier :

#
## Filter Dialog
#
_UI_TITLE_FILTER_DIALOG = Propri�t�s du filtre de la connexion
_UI_TITLE_FILTER = Sp�cifier un filtre
_UI_DESCRIPTION_FILTER = Sp�cifier un filtre en s�lectionnant un pr�dicat et en entrant une valeur ou en indiquant si une s�lection d'�l�ments doit �tre incluse ou exclue.
_UI_DESCRIPTION_SELECTION_ONLY = Sp�cifier un filtre en indiquant si une s�lection d'�l�ments doit �tre incluse ou exclue.
_UI_DESCRIPTION_EXPRESSION_ONLY = Sp�cifier un filtre en s�lectionnant un pr�dicat et en entrant une valeur.
_UI_RADIO_BUTTON_EXPRESSION = &Expression
_UI_LABEL_EXPRESSION = &Nom
_UI_COMBO_STARTS_WITH = Commence par les caract�res
_UI_COMBO_NOT_START_WITH = Ne commence pas par les caract�res
_UI_COMBO_CONTAINS = Contient les caract�res
_UI_COMBO_NOT_CONTAIN = Ne contient pas les caract�res
_UI_COMBO_ENDS_WITH = Finit par les caract�res
_UI_COMBO_NOT_END_WITH = Ne finit pas par les caract�res
_UI_RADIO_BUTTON_SELECTION = S�&lection
_UI_COMBO_INCLUDE_ITEMS = Inclure les �l�ments s�lectionn�s
_UI_COMBO_EXCLUDE_ITEMS = Exclure les �l�ments s�lectionn�s
_UI_BUTTON_SELECT_ALL = &S�lectionner tout
_UI_BUTTON_DESELECT_ALL = &D�s�lectionner tout
_UI_CHECKBOX_DISABLE_FILTER = D&�sactiver le filtre
_UI_MESSAGE_CRITERIA_REQUIRED = Sp�cifier des crit�res de filtrage.
_UI_MESSAGE_NO_QUOTES = La valeur de l'expression ne doit pas contenir de guillemets.
_UI_MESSAGE_SELECTION_REQUIRED = S�lectionner au moins un �l�ment.
_UI_SP_FILTER_PAGE_TITLE = Propri�t�s de filtre de proc�dure stock�e
_UI_TABLE_FILTER_PAGE_TITLE = Propri�t�s de filtre de table
_UI_SCHEMA_FILTER_PAGE_TITLE = Propri�t�s de filtre de sch�ma
_UI_TOOLTIP_NEW = Nouveau
_UI_TOOLTIP_DELETE = Supprimer
_UI_RADIO_BUTTON_AND = Remplir toutes les conditions
_UI_RADIO_BUTTON_OR = Remplir certaines conditions
_UI_COMBO_PREDICATE = Pr�dicat
_UI_TEXT_VALUE = Valeur

#
## Actions for Schema Management
#
SCHEMA_MANAGEMENT_CREATE_SCHEMA = Sch�ma
SCHEMA_MANAGEMENT_CREATE_TABLE = Table
SCHEMA_MANAGEMENT_CREATE_VIEW = Vue
SCHEMA_MANAGEMENT_CREATE_INDEX = Index
SCHEMA_MANAGEMENT_CREATE_BUFFER_POOL = R�serve du tampon
SCHEMA_MANAGEMENT_CREATE_PARTITION_GROUP = Groupe de partition
SCHEMA_MANAGEMENT_CREATE_DISTINCT_TYPE = Type distinct d�fini par l'utilisateur
SCHEMA_MANAGEMENT_CREATE_STRUCTURED_TYPE = Type structur� d�fini par l'utilisateur
SCHEMA_MANAGEMENT_CREATE_ARRAY_TYPE = Type de donn�es de tableau
SCHEMA_MANAGEMENT_CREATE_ROW_TYPE = Type de donn�es de ligne
SCHEMA_MANAGEMENT_CREATE_SEQUENCE = S�quence
SCHEMA_MANAGEMENT_CREATE_MQT = MQT
SCHEMA_MANAGEMENT_CREATE_ALIAS = Pseudo
SCHEMA_MANAGEMENT_CREATE_TRIGGER = D�clencheur
SCHEMA_MANAGEMENT_CREATE_ROLE = R�le
SCHEMA_MANAGEMENT_CREATE_USER = Utilisateur
SCHEMA_MANAGEMENT_CREATE_GROUP = Groupe
#
SCHEMA_MANAGEMENT_ADD_COLUMN = Colonne
SCHEMA_MANAGEMENT_ADD_CHECK_CONSTRAINT = Contrainte de v�rification
SCHEMA_MANAGEMENT_ADD_UNIQUE_CONSTRAINT = Contrainte unique
SCHEMA_MANAGEMENT_ADD_FOREIGN_KEY = Cl� �trang�re
