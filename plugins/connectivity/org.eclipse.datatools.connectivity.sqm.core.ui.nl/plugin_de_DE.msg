###############################################################################
# Copyright (c) 2001, 2004, 2008 IBM Corporation and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#     IBM Corporation - initial API and implementation
###############################################################################
pluginName=Eclipse Data Tools Platform SQM UI Plug-in
providerName=Eclipse Data Tools Platform

#
## Extension Point Names
#
LABEL_SERVICE_EXTENSION_POINT_NAME=labelService
ELEMENT_ID_EXTENSION_POINT_NAME=elementID
MARKER_NAVIGATION_PROVIDER_EXTENSION_POINT_NAME=markerNavigationProvider
DATA_SOURCE_EXPLORER_SORTER=sorterValidatorProvider
FILTER_INFORMATION_EXTENSION_POINT_NAME=filterInformation

#
## Model Explorer Selection
#
datatools.core.ui.modelExplorerSelection = Modell-Explorer-Auswahl

#
## Preferences for Label Decoration
#
datatools.core.ui.preferences.labeldecorators = Beschriftung � Dekoration

#
## Preferences
#
datatools.core.ui.preferences.data = SQL-Entwicklung
datatools.core.ui.preferences.output = Ausgabe

#
## Views
#
datatools.core.ui.modelElementProperties = Datenmodell-Element-Eigenschaften
datatools.core.ui.views.interactiveSQL = SQL anzeigen

#
## Model Explorer
#
datatools.core.ui.contentProviders = Physikalisches Modell Content-Provider
datatools.core.ui.parserProviders = Physikalisches Modell Parser-Provider
datatools.core.ui.iconProviders = Physikalisches Modell Icon-Provider

#
## Nature 
#
datatools.core.ui.projectNature = Datenbank-Projekt � Data Nature

#
## Wizards
# 
datatools.core.ui.category.project = Datenbank
datatools.core.ui.category.model = Datenbank-Modell
datatools.core.ui.project.basic = Datendesign-Projekt
datatools.core.ui.project.description = Erstellen Sie ein Datendesign-Projekt
datatools.core.ui.model.basic = Physikalisches Datenmodell

#
## Preferences
#
datatools.core.ui.preferences.modeler = Daten
datatools.core.ui.preferences.default = Datenbank-Standardeinstellungen

#
## Popup && Actions
#
datatools.core.ui.actions.close = Schlie�.en
datatools.core.ui.actions.add = SQL hinzuf�gen
datatools.core.ui.actions.addMQT = MQT
datatools.core.ui.actions.addSchema = Schema
datatools.core.ui.actions.addTable = Tabelle
datatools.core.ui.actions.addView = Ansicht
datatools.core.ui.actions.addColumn = Spalte
datatools.core.ui.actions.delete = L�schen
datatools.core.ui.actions.addTrigger = Ausl�sen
datatools.core.ui.globalActionHandlerProviders = Daten � globale Aktionen
datatools.core.ui.actions.selectSupplier = Navigieren Sie zur Tabelle f�r eindeutige Einschr�nkungen
datatools.core.ui.actions.fe=DDL erstellen...
datatools.core.ui.actions.re=Reverse-Engineer von DDL...
datatools.core.ui.actions.dataModeler = Data Modeler
datatools.core.ui.actions.addDomain = Dom�ne
datatools.core.ui.actions.addSequence = Sequenz
datatools.core.ui.actions.addStoredProcedure = Gespeicherte Prozedur
datatools.core.ui.actions.addJavaStoredProcedure = Java gespeicherte Prozedur
datatools.core.ui.actions.generateForeignKeyIndex = Index
datatools.core.ui.actions.generatePrimaryKeyIndex = Index
datatools.core.ui.actions.addDatabase = Datenbank
datatools.core.ui.actions.addTableIndex = Index
datatools.core.ui.actions.addTableCheckConstraint = Pr�f-Einschr�nkung
datatools.core.ui.actions.addUniqueConstraint = Eindeutige Einschr�nkung
datatools.core.ui.actions.addAlias = Alias
datatools.core.ui.actions.addDistinctUDT = Bestimmter benutzerdefinierter Typ
datatools.core.ui.actions.addStructuredUDT = Strukturierter benutzerdefinierter Typ
datatools.core.ui.actions.addMQTIndex = Index
datatools.core.ui.actions.addMQTTrigger = Ausl�sen
#
## Editors
#
datatools.core.ui.model.editor = SQL-Modell-Editor

#
## Decorators
#
datatools.core.ui.modelexplorer.modelExplorerColumnDecoration = Datentools � Spaltendatentyp
datatools.core.ui.modelexplorer.modelExplorerForeignKeyDecoration = Datentools � Fremd- oder Prim�rschl�sselindikator
datatools.core.ui.modelexplorer.DependencyDecoration = Datentools � Dependency Decoration
datatools.core.ui.modelexplorer.bookmarkDecoration  = Datentools � Bookmark Indicator
datatools.core.ui.modelexplorer.filterDecoration = Datentools - Server-Explorer-Filterknoten - Indikator
datatools.core.ui.modelexplorer.indextriggerDecoration = Datentools � Index und Ausl�ser-Dekoration

#
## Model Explorer Sorter Provider
#
datatools.core.ui.modelexplorer.sorterProviders = Modell-Explorer � Sorter Provider
datatools.core.ui.modelexplorer.menu.storageOrderSorter = Speicherungsreihenfolge
datatools.core.ui.modelexplorer.menu.name = Name
datatools.core.ui.modelexplorer.menu.type = Typ
datatools.core.ui.modelexplorer.menu.stereotype = Stereotyp
datatools.core.ui.modelexplorer.menu.visibility = Sichtbarkeit

#
## Model Explorer DnD
#
datatools.core.ui.modelexplorer.dragDrop = Drag & Drop

#
## Marker
#
datatools.core.ui.modelexplorer.marker.dangling = Alleinstehende Referenz


#
## Type for Label Service 
#
database = Datenbank
schema = Schema
baseTable = Tabelle
column = Spalte
domain = Dom�ne
udt = Benutzerdefinierter Typ
index = Index
procedure = Gespeicherte Prozedur
view = Ansicht
parameter = Parameter
trigger = Ausl�sen
sequence = Sequenz
source= Quelle
attributeDefinition = Attributdefinition
function = Benutzerdefinierte Funktion
dependency = Abh�ngigkeit
primaryKey = Prim�rschl�ssel
foreignKey = Fremdschl�ssel
folder = Logischer Ordner
CheckConstraint = Pr�f-Einschr�nkung
UniqueConstraint = Eindeutige Einschr�nkung
existingConnection = Verbindungs-Ordner
connectedConnection = Live-Verbindung
disconnectedConnection = Unterbrochene Verbindung
cachedConnection = Gepufferte Verbindung
catalog = Katalog
user = Benutzer
group = Gruppe
role = Rolle
authorization = Autorisierungs-ID

DEFAULT_SCHEMA_FILTER_PROPERTY_PAGE_NAME=Standardeinstellungen Schema-Filter
DEFAULT_TABLE_FILTER_PROPERTY_PAGE_NAME=Standardeinstellungen Tabellen-Filter
DEFAULT_STORED_PROCEDURE_FILTER_PROPERTY_PAGE_NAME=Standardeinstellungen Filter f�r gespeicherte Prozedur
FILTER_SETTINGS_PROPERTY_PAGE_NAME=Filter-Einstellungen
