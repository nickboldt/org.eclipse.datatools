## Copyright (c) 2005, 2009 Sybase, Inc.
## All rights reserved. This program and the accompanying materials
## are made available under the terms of the Eclipse Public License v1.0
## which accompanies this distribution, and is available at
## http://www.eclipse.org/legal/epl-v10.html
##
## Contributors:
##    Sybase, Inc. - initial API and implementation
##	  IBM Corporation = bug fix #203829
##	  Actuate Corporation - bug fix #261452
################################################################################ 
plugin.internal_error=Erreur interne - org.eclipse.datatools.connectivity
ImportProfilesDialog.btnOverwrite.text=&Remplacer les profils de connexion existants s'ils portent le m�me nom
ExportProfilesDialog.button.text2=&Parcourir...
ExportProfilesDialog.group.text=S�lectionnez les profils de connexion � exporter \:
ExportProfilesDialog.button.text1=&D�s�lectionner tout
ExportProfilesDialog.button.text=&S�lectionner tout
ImportProfilesDialog.button.text=&Parcourir...
ExportProfilesDialog.label.text=Indiquez un nom de &fichier \:
ImportProfilesDialog.label.text=Indiquez un nom de &fichier \:
ImportProfilesDialog.text.text=Remarque \: le profil de connexion � importer doit correspondre aux types qui peuvent �tre \n  cr��s � l'aide de l'Assistant de nouveau profil de connexion. Les types de \n  profils de connexion non pris en charge seront ignor�s.
ExportProfilesDialog.null.title=Exportation des profils de connexion
ImportProfilesDialog.null.title=Importation des profils de connexion
ExportProfilesDialog.btnEncryption.text=Chiffr&er le contenu du fichier
actions.export.noselection=S�lectionnez au moins un profil de connexion \!
actions.export.nofile=Indiquez un nom de fichier \!
actions.export.norepository = Sp�cifiez un r�f�rentiel cible.
actions.export.notvalidfile = Sp�cifiez un chemin et un nom de fichier corrects.
dialog.exception.title=Exception
dialog.exception.message=Exception \: {0}
NewCPWizard.title=Nouveau profil de connexion
IntroductionWizardPage.title=Page d'introduction
IntroductionWizardPage.intro=Cet assistant vous guide � travers les �tapes requises pour cr�er un profil de connexion.
CPWizardSelectionPage.title = Profil de connexion
CPWizardSelectionPage.desc = S�lectionnez un type de profil de connexion.
CPWizardSelectionPage.group = Types de profils de &connexion :
CPWizardSelectionPage.defaultName =Nouveau {0}
CPWizardSelectionPage.defaultNameExtended =Nouveau {0}({1})
actions.connect.job=T�che de connexion au serveur
actions.connect.uijob=R�g�n�ration de la vue
actions.ping.job=T�che de ping du serveur
actions.ping.uijob=T�che Afficher la bo�te de dialogue
actions.connect.title=Connexion au serveur...
actions.ping.title=Test de ping du serveur...
actions.ping.success=Ping r�ussi \!
actions.ping.failure=Echec du ping \!
actions.delete.title=Confirmation de la suppression
actions.delete.confirm=Voulez-vous vraiment supprimer le profil de connexion "{0}" ?
properties.dialog=Bo�te de dialogue des propri�t�s
properties.category.general=G�n�ralit�s
properties.connectionprofile.name=Nom du profil
properties.connectionprofile.desc=Description
properties.connectionprofile.autoconnect=Connexion automatique
properties.category.name=Nom de la cat�gorie
properties.category.id=ID de cat�gorie
ServersView.action.showproperties=&Propri�t�s
ServersView.action.refresh=&R�g�n�rer
ServersView.action.newCP=&Nouveau...
ServersView.action.exportCPs=&Exporter...
ServersView.action.importCPs=&Importer...
NewConnectionProfileWizard.title=Nouveau profil de connexion
NewConnectionProfileWizard.create.failure=Echec de la cr�ation du profil de connexion
NewConnectionProfileWizardPage.Status.DuplicateName=Le nom du profil de connexion existe d�j� \!
NewConnectionProfileWizardPage.Status.NoName=Indiquez un nom de profil de connexion \!
NewConnectionProfileWizardPage.Status.NoRepository = Sp�cifiez un r�f�rentiel.
NewConnectionProfileWizardPage.Status.NoSpacesInName = Le nom de profil de connexion ne doit pas commencer ou se terminer par un espace.
NewConnectionProfileWizardPage.title = Cr�er un profil de connexion
NewConnectionProfileWizardPage.desc = Saisissez les informations de profil.
NewConnectionProfileWizardPage.cp_name = No&m :
NewConnectionProfileWizardPage.cp_desc = &Description (facultatif) :
NewConnectionProfileWizardPage.choices=Veuillez s�lectionner \:
NewConnectionProfileWizardPage.summary_cp_name=Nom
NewConnectionProfileWizardPage.summary_cp_desc=Description
NewConnectionProfileWizardPage.Button.AutoConnect = Connexion &automatique au d�marrage
NewConnectionProfileWizardPage.Button.AutoConnect1 = Connexion automatique au d�marrage.
NewConnectionProfileWizardPage.summary_autoconnect = Connexion automatique au d�marrage
NewConnectionProfileWizardPage.summary_autoconnect_on_finish = Connexion automatique � la fin
NewConnectionProfileWizardPage.localRepository = Cr�er dans le r�f�rentiel d'espace de travail (local)
NewConnectionProfileWizardPage.chooseRepository = Choisissez un r�f�rentiel :
ConnectionProfileDetailsPage.Button.TestConnection=&Tester la connexion
ConnectionProfileDetailsPage.AskConfirmation=Bo�te de dialogue de confirmation
ConnectionProfileDetailsPage.AskReconnect=Les informations de connexion de ce profil de connexion ont �t� modifi�es. Voulez-vous vous reconnecter au serveur ?
SummaryWizardPage.title=R�capitulatif
SummaryWizardPage.description=Informations �manant des pages pr�c�dentes.
SummaryWizardPage.property=Propri�t�
SummaryWizardPage.value=Valeur
dialog.title.error=Erreur
dialog.title.success=R�ussite
rename.dialog.title=Bo�te de dialogue Attribution d'un nouveau nom
rename.dialog.message=Indiquez un nouveau nom de profil de connexion \:
rename.dialog.errmsg.existing=Le nom existe d�j�. Indiquez un autre nom \!
rename.dialog.errmsg.invalid=Nom incorrect. Indiquez un nom correct \!
rename.dialog.errmsg.NoSpacesInName = Le nom de profil de connexion ne doit pas commencer ou se terminer par un espace.
error.connect={1}.  Pour plus de d�tails, consultez le fichier de consignation.
error.contentExtension=Erreur de connexion � l''extension "{0}" sur le profil "{1}" (Erreur \: {2})
CPVersionPropertyPage.desc=Informations relatives � la version de {0}.\nCes informations ont �t� obtenues lors de la derni�re tentative de connexion.  Si la derni�re tentative de connexion a �chou�, aucune information relative � la version ne seront disponibles.
CPVersionPropertyPage.button.updateVersion=Se connecter et mettre � jour les informations sur la version
CPVersionPropertyPage.label.versionUnavailable=Les informations relatives � la version ne sont pas disponibles pour ce profil.
CPVersionPropertyPage.label.techVersions=Ce serveur comporte les technologies suivantes \:
ConnectionProfileSummaryPage.button.testConnection=&Tester la connexion
CommonLabelProviderBase.label.version={0} ({1} v. {2}) 
CommonLabelProviderBase.label.version.versionless={0} ({1}) 
CommonLabelProviderBase.label.localRepository=R�f�rentiel d'espace de travail (local)

properties.connectionprofile.type = Type de profil
DSE.Refresh.label = &Actualiser
DSE.View.Tooltip = Explorateur de source de donn�es

CPDeleteChange.name = Supprimer le profil de connexion {0}
CPDeleteChange.error.ProfileDoesNotExist = Le profil de connexion que vous essayez de supprimer n'existe pas.
CPDeleteChange.delete.failure = Echec de la suppression du profil de connexion.
CPDeleteProcessor.name = Processeur de suppression de connectivit� DTP
CPDuplicateProcessor.name = Processeur de duplication de profil de connexion DTP
CPCopyChange.name = Dupliquer le profil de connexion {0}
CPCopyChange.error.ProfileDoesNotExist = Le profil de connexion que vous essayez de dupliquer n'existe pas.
CPCopyChange.title.error = Echec de la duplication du profil de connexion.
CPCopyChange.error.InvalidTarget = La cible sp�cifi�e n'est pas un r�f�rentiel de profils de connexion valide.
CPCopyChange.error.RepositoryNotConnected = Non connect� au r�f�rentiel de profils de connexion cible {0}.
CPMoveProcessor.name = Processeur de d�placement de profil de connexion DTP
CPMoveChange.name = D�placer le profil de connexion {0}
CPMoveChange.error.ProfileDoesNotExist = Le profil de connexion que vous essayez de d�placer n'existe pas.
CPMoveChange.title.error = Echec du d�placement du profil de connexion.
CPCreateChange.name = Cr�er le profil de connexion {0}
CPCreateChange.error.NewProfileDoesNotHaveName = Un nom est requis pour la cr�ation du nouveau profil de connexion.
CPCreateChange.error.NewProfileAlreadyExists = Un profil de connexion portant le nouveau nom existe d�j�.
CPCreateChange.error.NewProfileDoesNotHaveProviderID = Un ID de fournisseur de profils de connexion est requis pour la cr�ation du nouveau profil de connexion.
CPCreateChange.error.NewProfileDoesNotHaveNonNullPropertiesObject = Un objet de propri�t�s non nul est requis pour la cr�ation du nouveau profil de connexion.
CPCreateChange.create.failure = Echec de la cr�ation du profil de connexion.
CPCreateProcessor.name = Processeur de cr�ation de connectivit� DTP
CPRenameChange.name = Renommer le profil de connexion {0}
CPRenameProcessor.name = Processeur de r�attribution de nom de connectivit� DTP
CPRenameChange.title.error = Echec de la r�attribution d'un nom au profil de connexion.

PropertyDescriptor.error.title = Erreur lors du traitement du descripteur de propri�t� pour la d�finition de pilote
PropertyDescriptor.error.msg = Erreur lors du traitement des propri�t�s de d�finition du pilote.
PasswordTextPropertyDescriptor.property.label = Mot de passe
DriverClassBrowsePropertyDescriptor.property.label = Classe de pilote
DriverClassBrowsePropertyDescriptor.jardialog.title = Classes disponibles � partir de la liste Jar
DriverClassBrowsePropertyDescriptor.jardialog.msg = Indiquez le nom de la classe de pilote ou s�lectionnez une classe parmi les JAR disponibles.
DriverClassBrowsePropertyDescriptor.noclasses.title = Aucune classe de pilote disponible
DriverClassBrowsePropertyDescriptor.noclasses.msg = Aucune classe de pilote disponible pour la liste jar en cours.

StatusBar.Connected = Connect�
StatusBar.Disconnected = D�connect�
StatusBar.ConnectedMessage = {0} ({1})

StatusBar.WorkingOffline = Travail hors ligne

DATATOOLS.SERVER.UI.EXPLORER.WORKOFFLINE = &Travailler hors ligne
DATATOOLS.SERVER.UI.EXPLORER.UPDATE_OFFLINE = &Enregistrer hors ligne

DriverPropertyEditorDescriptor.InvalidID = ID valide manquant pour le descripteur de l'�diteur de propri�t� du pilote
DriverPropertyEditorDescriptor.InvalidTargetTemplateID = ID de mod�le cible valide manquant pour le descripteur de l'�diteur de propri�t� du pilote
DriverPropertyEditorDescriptor.InvalidTargetPropertyId = ID de propri�t� cible valide manquant pour le descripteur de l'�diteur de propri�t� du pilote
DriverPropertyEditorDescriptor.InvalidCustomPropertyEditorClass = Editeur de propri�t� personnalis� valide manquant pour le descripteur de l'�diteur de propri�t� du pilote

ExtensibleProfileDetailsWizardPage.title = Sp�cifiez un lecteur et les informations de connexion
ExtensibleProfileDetailsWizardPage.description = Dans le menu d�roulant, s�lectionnez un lecteur et fournissez les informations de connexion.
ExtensibleProfileDetailsWizardPage.driverCombo.label = &Lecteurs :
ExtensibleNewConnectionProfileWizard.title = Nouveau profil de connexion

DriverUIContributorComposite.group = Propri�t�s

CommonDriverUIContributor.optionaltab = Fa&cultatif
CommonDriverUIContributor.optionalProps.label = Propri�t�s suppl�mentaires :
CommonDriverUIContributor.generaltab = &G�n�ral

OtherDriverUIContributor.databaseName.label = B&ase de donn�es :
OtherDriverUIContributor.url.label = &URL :
OtherDriverUIContributor.userName.label = Nom d'utili&sateur :
OtherDriverUIContributor.password.label = &Mot de passe :
OtherDriverUIContributor.savePassword.label = Enregistre&r mot de passe
OtherDriverUIContributor.summaryData.database = Base de donn�es
OtherDriverUIContributor.summaryData.username = Nom d'utilisateur
OtherDriverUIContributor.summaryData.savePassword = Enregistrer mot de passe
OtherDriverUIContributor.summaryData.true = vrai
OtherDriverUIContributor.summaryData.false = faux
OtherDriverUIContributor.summaryData.url = URL

OtherDriverUIContributor.errormessage.requiresdatabase = Entrez un nom pour la base de donn�es.
OtherDriverUIContributor.errormessage.requiresurl = Entrez une URL.
OtherDriverUIContributor.errormessage.requiresusername = Entrez un nom d'utilisateur.

ConnectAction.title = Propri�t�s de {0}

Boolean.true = vrai
Boolean.false = faux

NewRepositoryWizard.title = Fen�tre du nouvel Assistant du r�f�rentiel

NewConnectionProfileWizardPage.Status.ContainsColon= Le nom du profil de connexion ne peut pas comporter la colonne (:) !

