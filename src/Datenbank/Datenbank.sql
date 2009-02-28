-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 27. Februar 2009 um 22:39
-- Server Version: 5.0.67
-- PHP-Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Datenbank: `bibliotheksverwaltung`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `anwender`
--

CREATE TABLE IF NOT EXISTS `anwender` (
  `ANWENDERNAME` char(32) NOT NULL,
  `PASSWORT` char(64) NOT NULL,
  `hierarchiestufe` tinyint(1) NOT NULL default '1',
  `AKTIV` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`ANWENDERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten f�r Tabelle `anwender`
--

INSERT INTO `anwender` (`ANWENDERNAME`, `PASSWORT`, `hierarchiestufe`, `AKTIV`) VALUES
('m.beier', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1),
('s.blaurock', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1),
('s.terzyk', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `ausleiher`
--

CREATE TABLE IF NOT EXISTS `ausleiher` (
  `BENUTZERID` int(11) NOT NULL auto_increment,
  `VORNAME` char(32) default NULL,
  `NACHNAME` char(32) default NULL,
  `STRASSE` char(32) default NULL,
  `HAUSNUMMER` char(8) default NULL,
  `PLZ` decimal(5,0) default NULL,
  `STADT` char(32) default NULL,
  `AKTIV` tinyint(1) default NULL,
  PRIMARY KEY  (`BENUTZERID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Daten f�r Tabelle `ausleiher`
--

INSERT INTO `ausleiher` (`BENUTZERID`, `VORNAME`, `NACHNAME`, `STRASSE`, `HAUSNUMMER`, `PLZ`, `STADT`, `AKTIV`) VALUES
(1, 'Peter', 'Hirsch', 'Ringbahnstra�e', '12', 10711, 'Berlin', 1),
(2, 'Simon', 'Jelkes', 'Belziger Stra�e', '45', 10823, 'Berlin', 1),
(3, 'Daniel', 'Berger', 'Quedlinburgerstra�e', '2', 10589, 'Berlin', 1),
(4, 'Nico', 'Fischer', 'Heidekampweg', '87', 12437, 'Berlin', 1),
(5, 'Andreas', 'Falk', 'Lichtenrader Damm', '49', 12305, 'Berlin', 1),
(6, 'Simon', 'Kupper', 'Birkbuschstra�e', '76', 12167, 'Berlin', 1),
(7, 'Abdul', 'Cemekoglu', 'Gleimstra�e', '10', 10437, 'Berlin', 1),
(8, 'Roland', 'Geldmacher', 'Samariterstra�e', '36', 10247, 'Berlin', 1),
(9, 'Thomas', 'Breaker', 'Mahlsdorfer Stra�e', '59', 15366, 'Hoppegarten', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `beinhaltet`
--

CREATE TABLE IF NOT EXISTS `beinhaltet` (
  `TAGID` int(11) NOT NULL,
  `MEDIENID` int(11) NOT NULL,
  PRIMARY KEY  (`TAGID`,`MEDIENID`),
  KEY `BEINHALTET_FK` (`TAGID`),
  KEY `BEINHALTET2_FK` (`MEDIENID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten f�r Tabelle `beinhaltet`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `exemplar`
--

CREATE TABLE IF NOT EXISTS `exemplar` (
  `EXEMPLARID` int(11) NOT NULL auto_increment,
  `ZUSTANDSID` int(11) default NULL,
  `BENUTZERID` int(11) default NULL,
  `MEDIENID` int(11) default NULL,
  `RUECKGABEDATUM` date default NULL,
  `VERLAENGERUNG` int(11) default NULL,
  `AKTIV` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`EXEMPLARID`),
  KEY `LEIHT_AUS_FK` (`BENUTZERID`),
  KEY `HAT_FK` (`ZUSTANDSID`),
  KEY `GEHOERT_ZU_FK` (`MEDIENID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Daten f�r Tabelle `exemplar`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `konfiguration`
--

CREATE TABLE IF NOT EXISTS `konfiguration` (
  `NAME` char(64) NOT NULL,
  `WERT` char(128) NOT NULL,
  PRIMARY KEY  (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten f�r Tabelle `konfiguration`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `LOGID` bigint(20) NOT NULL auto_increment,
  `VORGANGSID` int(11) default NULL,
  `BENUTZERID` int(11) default NULL,
  `ANWENDERNAME` char(32) default NULL,
  `EXEMPLARID` int(11) default NULL,
  `LOGDATUM` datetime NOT NULL,
  `KOMMENTAR` char(128) default NULL,
  PRIMARY KEY  (`LOGID`),
  KEY `RELATIONSHIP_1_FK` (`VORGANGSID`),
  KEY `LOGGT_FK` (`EXEMPLARID`),
  KEY `LOGGT3_FK` (`ANWENDERNAME`),
  KEY `LOGGT2_FK` (`BENUTZERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Daten f�r Tabelle `log`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `medium`
--

CREATE TABLE IF NOT EXISTS `medium` (
  `MEDIENID` int(11) NOT NULL auto_increment,
  `TITEL` char(128) default NULL,
  `AUTORVORNAME` char(32) default NULL,
  `AUTORNACHNAME` char(32) default NULL,
  `VERLAG` char(128) default NULL,
  `ERSCHEINUNGSJAHR` int(11) default NULL,
  `ISBN` char(32) default NULL,
  `AKTIV` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`MEDIENID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=196 ;

--
-- Daten f�r Tabelle `medium`
--

INSERT INTO `medium` (`MEDIENID`, `TITEL`, `AUTORVORNAME`, `AUTORNACHNAME`, `VERLAG`, `ERSCHEINUNGSJAHR`, `ISBN`, `AKTIV`) VALUES
(1, 'Die baltischen L�nder : Estland, Lettland, Litauen vom Mittelalter bis zur Gegenwart', 'Michael', 'Garleff', 'Pustet', 2001, '3-7917-1770-7', 1),
(2, 'Wie ich lernte, die Frauen zu lieben: Die amour�sen Erinnerungen des Andr�s Vajda', 'Stephen', 'Vzinczey', 'SchirmerGraf', 2004, '3-86555-008-8', 1),
(3, 'Ich liebte einen Russen: Zur Erinnerung an die schneereichen Winter der Kindheit', 'Maimu', 'Berg', 'Gollenstein', 1998, '3-930008-83-1', 1),
(4, 'Litauisch Wort f�r Wort : das ganze Buch auf CD-ROM plus Audio-Aussprachetrainer', 'Katrin', 'J�hnert', 'Reise Know-How', 2004, '3-8317-6071-3', 1),
(5, 'Von den Ufern der Memel ins Ungewisse : Eine Jugend im Schatten des Holocaust', 'Zwi', 'Katz', 'Pendo', 2002, '3-85842-490-0', 1),
(6, 'Reise in das Baltikum : auf Spurensuche in Estland, Lettland und Litauen.', 'Michael', 'Welder', 'Rautenberg', 2002, '3-8003-3028-8', 1),
(7, 'Estland entdecken : skandinavische Impressionen im n�rdlichen Baltikum', 'Klaus', 'Schameitat', 'Trescher', 2003, '3-89794-036-1', 1),
(8, 'Und sie feierten Hochzeit vierzig Tage und vierzig N�chte lang', 'Niki', 'Marangou', 'Romiosini', 2001, '3-929889-59-5', 1),
(9, 'Baltische Staaten : Estland, Lettland, Litauen, Kaliningrad', 'Torbus', 'Tomasz', 'Nelles', 2004, '3-88618-801-9', 1),
(10, 'Ein Held seiner Zeit : Die Bekenntnisse des Korn�l Esti', 'Desz�', 'Kosztol�nyi', 'Rowohlt', 2004, '3-87134-489-3', 1),
(11, 'Liebende f�r eine Nacht, Liebende f�r einen Tag', 'Ivan', 'Klima', 'Hanser', 2002, '3-446-17227-0', 1),
(12, 'Hordubal. Der Meteor. Ein gew�hnliches Leben', 'Karel', 'Capek', 'DVA', 1999, '3-421-05233-6', 1),
(13, 'Die Abenteuer des braven Soldaten Schwejk', 'Jaroslav', 'Hasek', 'Random House Audio', 2001, '3-89830-149-4', 1),
(14, 'Die Abenteuer des braven Soldaten Schwejk', 'Jaroslav', 'Hasek', 'AtV 1928', 2003, '3-7466-1928-9', 1),
(15, 'Freiheits�bungen : Und andere kleine Prosa', 'Peter', 'N�das', 'Berlin Verlag', 2004, '3-8270-0533-7', 1),
(16, 'Litauen : ein literarischer Reisebegleiter', 'Claudia', 'Sinnig', 'Insel', 2002, '3-458-34544-2', 1),
(17, 'Freundinnen aus dem Haus der Traurigkeit', 'Eva', 'Kanturkova', 'DVA', 2003, '3-421-05249-2', 1),
(18, 'Die unertr�gliche Leichtigkeit des Seins', 'Milan', 'Kundera', 'Fischer 5992', 2002, '3-596-25992-4', 1),
(19, 'Der Doppelg�nger und andere Geschichten', 'Slawomir', 'Mrozek', 'Diogenes', 2000, '3-257-06242-7', 1),
(20, 'Warten auf Dunkelheit, Warten auf Licht', 'Ivan', 'Klima', 'dtv 12742', 2000, '3-423-12742-2', 1),
(21, 'Ich habe den englischen K�nig bedient', 'Bohumil', 'Hrabal', 'st 3502', 2003, '3-518-45502-8', 1),
(22, 'Niki oder die Geschichte eines Hundes', 'Tibor', 'D�ry', 'Das Arsenal', 2001, '3-931109-26-7', 1),
(23, 'Kaddisch f�r ein nichtgeborenes Kind', 'Imre', 'Kert�sz', 'rororo 22574', 2002, '3-499-22574-3', 1),
(24, 'Im Dienst der Gro�en Hochseefischerei', 'Richard', 'Neu', 'Hauschild', 2002, '3-89757-144-7', 1),
(25, 'Baltikum : Estland, Lettland, Litauen', 'Jan', 'Pallokat', 'Mairs Geogra-phischer Verl. \n(Marco Polo)', 2003, '3-8297-0258-2', 1),
(26, '...doch die M�rchen sprechen Deutsch', 'Ota', 'Filip', 'Langen-M�ller', 1996, '3-7844-2584-4', 1),
(27, 'Das Buch vom Lachen und Vergessen', 'Milan', 'Kundera', 'dtv 12790', 2000, '3-423-12790-2', 1),
(28, 'Die Legende von den Tr�nengauklern', 'Laszlo', 'Darvasi', 'Suhrkamp', 2001, '3-518-41284-1', 1),
(29, 'Ich dachte an die goldenen Zeiten', 'Bohumil', 'Hrabal', 'Suhrkamp', 1999, '3-518-41048-2', 1),
(30, 'Ich bin eine Fliege beim Minister', 'Istv�n', 'E�rsi', 'Wieser', 2004, '3-85129-457-2', 1),
(31, 'Das Buch der l�cherlichen Liebe', 'Milan', 'Kundera', 'Fischer 9264', 2004, '3-596-29264-6', 1),
(32, 'Geschichte der baltischen L�nder', 'Ralph', 'Tuchtenhagen', 'Beck\n(Beck''sche Reihe)\n', 2005, '3-406-50855-3', 1),
(33, 'Die phantastischen Erz�hlungen', 'Stanislaw', 'Lem', 'st 1525', 2003, '3-518-38025-7', 1),
(34, 'Ein anderes Leben gibt es nicht', 'Maria', 'Nurowska', 'Fischer 13615', 2001, '3-596-13615-6', 1),
(35, 'Das Leben des Balthasar R�ssow', 'Jaan', 'Kross', 'dtv 12563', 1999, '3-423-12563-2', 1),
(36, 'Der Mensch auf der Landstra�e', 'Jan', 'Cep', 'DVA', 2003, '3-421-05246-8', 1),
(37, 'Der Teufel auf dem Kirchturm', '\nMarek', 'Lawrynowicz', 'dtv 13191', 2004, '3-423-13191-8', 1),
(38, 'Die lange Welle hinterm Kiel', 'Pavel', 'Kohout', 'btb 72965', 2002, '3-442-72965-3', 1),
(39, 'Litauisch Aussprache-Trainer', 'Katrin', 'J�hnert', 'Reise Know-How', 2004, '3-8317-6080-2', 1),
(40, 'Lolo und andere Geschichten', 'Slawomir', 'Mrozek', 'Diogenes', 2000, '3-257-06243-5', 1),
(41, 'Das Haus der Barmherzigkeit', 'Ivan', 'Cankar', 'Drava', 1996, '3-85435-257-3', 1),
(42, 'Siebenmal in der Hauptrolle', 'Egon', 'Hostovsky', 'DVA', 2004, '3-421-05252-2', 1),
(43, 'Die Hilfsverben des Herzens', 'P�ter', 'Esterh�zy', 'BS 1374', 2004, '3-518-22374-7', 1),
(44, 'Die Nacht vor der Scheidung', 'S�ndor', 'M�rai', 'H�rbuch\nHamburg', 2004, '3-89903-176-8', 1),
(45, 'Die Nacht vor der Scheidung', 'S�ndor', 'M�rai', 'Piper', 2003, '3-492-04287-2', 1),
(46, 'Lettisch Aussprache-Trainer', 'Bernardo', 'Christophe', 'Reise Know-How', 2003, '3-8317-6088-8', 1),
(47, 'Roman eines Schicksallosen', 'Imre', 'Kert�sz', 'rororo 22576', 2004, '3-499-22576-X', 1),
(48, 'Bekenntnisse eines B�rgers', 'S�ndor', 'M�rai', 'SP 3081', 2002, '3-492-23081-4', 1),
(49, 'Das Verm�chtnis der Eszter', 'S�ndor', 'M�rai', 'SP 3511', 2002, '3-492-23511-5', 1),
(50, 'Das Wunder des San Gennaro', 'S�ndor', 'M�rai', 'Sp 7044', 2004, '3-492-27044-1', 1),
(51, 'Ende eines Familienromans.', 'Peter', 'N�das', 'rororo 22582', 1999, '3-499-22582-4', 1),
(52, 'Die letzte Fenstergiraffe', 'P�ter', 'Zilahy', 'Eichborn', 2004, '3-8218-0755-5', 1),
(53, 'Tanz auf fremder Hochzeit', 'Hanna', 'Krall', 'Neue Kritik', 1993, '3-8015-0265-1', 1),
(54, 'Die sch�ne Frau Seidenman', 'Andrzej', 'Szczypiorski', 'Diogenes', 2000, '3-257-21945-8', 1),
(55, 'Ich ging nach einem Regen', 'Michael; Jung, Wolfgang (Hrsg.)', 'Adams', 'Gollenstein', 2000, '3-933389-28-3', 1),
(56, 'Sergijs letzte Versuchung', 'Jani', 'Virk', 'Wieser', 2004, '3-85129-455-6', 1),
(57, 'Die invaliden Geschwister', 'Egon', 'Bondy', 'Elfenbein', 1998, '3-932245-25-3', 1),
(58, 'Die Hundej�ger von Lojang', 'Laszlo', 'Darvasi', 'Suhrkamp', 2003, '3-518-41427-5', 1),
(59, 'Estnisch f�r Globetrotter', 'Irja', 'Gr�nholm', 'Reise Know-How', 0, '3-89416-120-5', 1),
(60, 'Die Frauen von Wesenberg', 'Jaan', 'Kross', 'Hanser', 1997, '3-446-19120-8', 1),
(61, 'Wie Laub von einem Baum', 'Peter (Hrsg.)', 'Zajac', 'Gollenstein', 1994, '3-930008-07-6', 1),
(62, ' Der siebente Lebenslauf', 'Ota', 'Filip', 'Herbig', 2001, '3-7766-2234-2', 1),
(63, 'Richter in eigener Sache', 'Ivan', 'Klima', 'Zsolnay', 2002, '3-552-04831-6', 1),
(64, 'Die Rache der Baumeister', 'Milos', 'Urban', 'rororo 23342', 2003, '3-499-23342-8', 1),
(65, 'Litauisch Wort f�r Wort', 'Katrin', 'J�hnert', 'Reise Know-How', 2001, '3-89416-244-9', 1),
(66, 'Der Verr�ckte des Zaren', 'Jaan', 'Kross', 'dtv 20665', 2003, '3-423-20655-1', 1),
(67, 'Da ist kein Fluss mehr', 'Hanna', 'Krall', 'btb 72631', 2001, '3-442-72631-X', 1),
(68, 'Der Himmel unter Berlin', 'Jaroslav', 'Rudis', 'Rowohlt', 2004, '3-87134-496-6', 1),
(69, 'Der B�cker Jan Marhoul', 'Vladislav', 'Vancura', 'DVA', 2000, '3-421-05237-9', 1),
(70, 'Litauen mit Kaliningrad', 'G�nther', 'Sch�fer', 'Reise Know-How Verlag Rump', 2003, '3-8317-1152-6', 1),
(71, 'Lettisch Wort f�r Wort', 'Bernardo', 'Christophe', 'Reise Know-How', 2002, '3-89416-273-2', 1),
(72, 'Estnisch Wort f�r Wort', 'Irja', 'Gr�nholm', 'Reise Know-How', 1999, '3-89416-245-7', 1),
(73, 'Grashalme aus Lettland', 'Miervaldis', 'Birze', 'edition memoria', 2000, '3-930353-12-1', 1),
(74, 'Lehrjahre des Gammelns', '\nMarek', 'Lawrynowicz', 'Beck', 2002, '3-406-48966-4', 1),
(75, 'Der Mensch vom Mars :', 'Stanislaw', 'Lem', 'st.2145', 2003, '3-518-38645-X', 1),
(76, 'Das Leben f�r Anf�nger', 'Slawomir', 'Mrozek', 'Diogenes', 2004, '3-257-06453-5', 1),
(77, 'Der russische Geliebte', 'Maria', 'Nurowska', 'Fischer 14876', 2003, '3-596-14876-6', 1),
(78, 'Galizische Geschichten', 'Andrzej', 'Stasiuk', 'st 3620', 2004, '3-518-45620-2', 1),
(79, 'Amerikanischer Whiskey', 'Andrzej', 'Szczypiorski', 'detebe 22415', 2000, '3-257-22415-X', 1),
(80, 'Selbstportr�t mit Frau', 'Andrzej', 'Szczypiorski', 'detebe 22871', 1996, '3-257-22871-6', 1),
(81, 'Allein gegen die Nacht', 'Dominik', 'Tatarka', 'Wieser', 2004, '3-85129-469-6', 1),
(82, 'Das andere Weihnachten', 'Ota', 'Filip', 'Langen-M�ller', 2004, '3-7844-2972-6', 1),
(83, 'Sternstunde der M�rder', 'Pavel', 'Kohout', 'btb 72175', 1997, '3-442-72175-X', 1),
(84, 'Das Leben ist anderswo', 'Milan', 'Kundera', 'dtv 12730', 2000, '3-423-12730-9', 1),
(85, 'Ein Hund mit Charakter', 'S�ndor', 'M�rai', 'SP 4009', 2004, '3-492-24009-7', 1),
(86, 'Die Welt hinter Dukla', 'Andrzej', 'Stasiuk', 'Suhrkamp', 2001, '3-518-41205-1', 1),
(87, 'Wei�e N�chte mit Hahn', 'Manfred (Hrsg.)', 'J�hnichen', 'Gollenstein', 1996, '3-930008-36-X', 1),
(88, 'Blut ist kein Wasser', 'Josef', 'Jedlicka', 'DVA', 2002, '3-421-05244-1', 1),
(89, 'Die Pendragon-Legende', 'Antal', 'Szerb', 'dtv 24425', 2004, '3-423-24425-9', 1),
(90, 'Afrikanisches Fieber', 'Ryszard', 'Kapuczinski', 'Eichborn', 1999, '3-8218-4483-3', 1),
(91, 'Ber�hmte Liebespaare', 'Boleslaw', 'Lubosz', 'Gollenstein', 1996, '3-930008-35-1', 1),
(92, 'Den Schatten fangen', 'Andrzej', 'Szczypiorski', 'detebe 22789', 2000, '3-257-22789-2', 1),
(93, 'Der Teufel im Graben', 'Andrzej', 'Szczypiorski', 'detebe 22739', 1995, '3-257-22739-6', 1),
(94, 'Nacht, Tag und Nacht', 'Andrzej', 'Szczypiorski', 'detebe 22635', 2000, '3-257-22635-7', 1),
(95, 'Ur und andere Zeiten', 'Olga', 'Togarczuk', 'Berlin Verlag', 2000, '3-8270-0340-7', 1),
(96, 'Die wunderbaren Wege', 'Magdalena', 'Sadlon', 'dtv 13101', 2003, '3-423-13102-2', 1),
(97, 'Fr�hliches Begr�bnis', 'Tibor', 'D�ry', 'Das Arsenal', 1995, '3-921810-71-X', 1),
(98, 'Die englische Flagge', 'Imre', 'Kert�sz', 'rororo 22572', 2002, '3-499-22572-7', 1),
(99, 'Die Gr�fin von Parma', 'S�ndor', 'M�rai', 'SP 4040', 2004, '3-492-24040-2', 1),
(100, 'Wandlungen einer Ehe', 'S�ndor', 'M�rai', 'H�rbuch\nHamburg', 2003, '3-89903-129-6', 1),
(101, 'Wandlungen einer Ehe', 'S�ndor', 'M�rai', 'SP 4167', 2004, '3-492-24167-0', 1),
(102, 'Buch der Erinnerung', 'Peter', 'N�das', 'rororo 22581', 1999, '3-499-22581-6', 1),
(103, 'Sterne der Eiszeit', 'Renata', 'Serelyte', 'Rowohlt Berlin', 2002, '3-87134-457-5', 1),
(104, 'Taghaus, Nachthaus', 'Olga', 'Togarczuk', 'dtv 13166', 2004, '3-423-13166-7', 1),
(105, 'Hochzeiten im Hause', 'Bohumil', 'Hrabal', 'st. 2414', 1995, '3-518-38914-9', 1),
(106, 'Meine ersten Lieben', 'Ivan', 'Klima', 'dtv 12309', 1997, '3-423-12309-5', 1),
(107, 'Die Unsterblichkeit', 'Milan', 'Kundera', 'Fischer 10672', 2004, '3-596-10672-9', 1),
(108, 'Der Mann aus Zelary', 'Kveta', 'Leg�tova', 'dtv 24420', 2004, '3-423-24420-8', 1),
(109, 'Die traurigen Augen', 'Ivan', 'Olbracht', 'DVA', 2001, '3-421-05569-6', 1),
(110, 'Wir f�nf und Jumbo', 'Karel', 'Polacek', 'DVA', 2001, '3-421-05239-5', 1),
(111, 'Leben mit dem Stern', 'Jiri', 'Weil', 'DVA', 2000, '3-421-05238-7', 1),
(112, 'Die jungen Rebellen', 'S�ndor', 'M�rai', 'H�rbuch\nHamburg', 2001, '3-89903-017-6', 1),
(113, 'Die jungen Rebellen', 'S�ndor', 'M�rai', 'SP 3898', 2003, '3-492-23898-X', 1),
(114, 'Dichtung und Prosa', 'Adam', 'Mickiewicz', 'Suhrkamp', 2000, '3-518-40665-5', 1),
(115, 'Der S�nder Lennart', 'Ivan', 'Cankar', 'Drava', 2002, '3-85435-376-6', 1),
(116, 'Eine Frau besorgen', 'Laszlo', 'Darvasi', 'es 2448', 2003, '3-518-12448-X', 1),
(117, 'Harmonia Caelestis', 'P�ter', 'Esterh�zy', 'BVT', 2004, '3-8333-0114-7', 1),
(118, 'Detektivgeschichte', 'Imre', 'Kert�sz', 'Rowohlt', 2004, '3-498-03525-8', 1),
(119, 'Ich � ein anderer', 'Imre', 'Kert�sz', 'rororo 22573', 2002, '3-499-22573-5', 1),
(120, 'Reise im Mondlicht', 'Antal', 'Szerb', 'H�rbuch\nHamburg', 2004, '3-89903-160-1', 1),
(121, 'Reise im Mondlicht', 'Antal', 'Szerb', 'dtv 24370', 2004, '3-423-24370-8', 1),
(122, 'Frieden auf Erden', 'Stanislaw', 'Lem', 'st 1574', 2004, '3-518-38074-5', 1),
(123, 'Zum starken Engel', 'Jerzy', 'Pilch', 'Luchterhand Literaturverlag', 2002, '3-630-87131-3', 1),
(124, 'Aus fremdem Leben', 'Ivan', 'Cankar', 'Drava', 1997, '3-85435-279-4', 1),
(125, 'Luzifers L�cheln', 'Drago', 'Jancar', 'Wieser', 1996, '3-85129-159-X', 1),
(126, 'Gottes Regenbogen', 'Jaroslav', 'Durych', 'DVA', 1999, '3-421-05232-8', 1),
(127, 'Ich � ein anderer', 'Imre', 'Kert�sz', 'Der H�r Verlag', 2003, '3-89940-118-2', 1),
(128, 'Die Astronauten', 'Stanislaw', 'Lem', 'st 441', 2003, '3-518-36941-5', 1),
(129, 'Das Tal der Issa', 'Czeslaw', 'Milosz', 'Eichborn', 2000, '3-8218-4709-3', 1),
(130, 'Briefe der Liebe', 'Maria', 'Nurowska', 'Fischer 12500', 2003, '3-596-12500-6', 1),
(131, 'Fr�ulein Niemand', 'Tomek', 'Tryzna', 'btb 72500', 1999, '3-442-72500-3', 1),
(132, 'Rauschen im Kopf', 'Drago', 'Jancar', 'dtv 13051', 2003, '3-423-13051-2', 1),
(133, 'Ein Liebessommer', 'Ivan', 'Klima', 'dtv 12339', 1997, '3-423-12339-7', 1),
(134, 'Die Unwissenheit', 'Milan', 'Kundera', 'Fischer 15128', 2003, '3-596-15128-7', 1),
(135, 'Die Beschneidung', 'Gy�rgy', 'Dalos', 'st 3052', 1999, '3-518-39552-1', 1),
(136, 'Das Buch Hrabals', 'P�ter', 'Esterh�zy', 'BVT', 2004, '3-8333-0032-9', 1),
(137, 'Sirene der Adria', 'G�bor', 'G�rgey', 'SALON-Literaturverl.', 2004, '3-9809635-0-0', 1),
(138, 'Galeerentagebuch', 'Imre', 'Kert�sz', 'rororo 22575', 2002, '3-499-22575-1', 1),
(139, 'Himmel und Erde', 'S�ndor', 'M�rai', 'SP 3714', 2004, '3-492-23714-2', 1),
(140, 'Baltische L�nder', 'Claudia', 'Marenbach', 'M�ller', 2003, '3-89953-113-2', 1),
(141, 'Die Gouvernante', 'Stefan', 'Chwin', 'rororo 23362', 2003, '3-499-23362-2', 1),
(142, 'Tod in Danzig', 'Stefan', 'Chwin', 'rororo 22623', 2001, '3-499-22623-2', 1),
(143, 'Spanische Augen', 'Maria', 'Nurowska', 'Fischer 13194', 2002, '3-596-13194-4', 1),
(144, 'Der weisse Rabe', 'Andrzej', 'Stasiuk', 'rororo 22692', 2000, '3-499-22692-8', 1),
(145, 'Liebesgespr�che', 'Ivan', 'Klima', 'Zsolnay', 2002, '3-552-05184-9', 1),
(146, 'Abschiedswalzer', 'Milan', 'Kundera', 'dtv 12429', 1998, '3-423-12429-6', 1),
(147, 'Die Langsamkeit', 'Milan', 'Kundera', 'Fischer 13088', 2004, '3-596-13088-3', 1),
(148, 'Die Besessenen', 'Witold', 'Gombrowicz', 'dtv 11444', 1992, '3-423-11444-4', 1),
(149, 'Roboterm�rchen', 'Stanislaw', 'Lem', 'st 856', 2004, '3-518-37356-0', 1),
(150, 'Roboterm�rchen', 'Stanislaw', 'Lem', 'H�rbuchproduktionen', 2001, '3-89614-236-4', 1),
(151, 'Fin de si�cle', 'Peter (Hrsg.)', 'Demetz', 'DVA', 2004, '3-421-05251-4', 1),
(152, 'Der Gottsucher', 'Gy�rgy', 'Dalos', 'st 3251', 2001, '3-518-39751-6', 1),
(153, 'Buch der V�ter', 'Mikl�s', 'V�mos', 'btb', 2004, '3-442-75118-7', 1),
(154, 'Die Regenhexe', 'Jurga', 'Ivanauskaite', 'dtv 13132', 2004, '3-423-13132-2', 1),
(155, 'Tans-Atlantik', 'Witold', 'Gombrowicz', 'Fischer 16438', 2004, '3-596-16438-9', 1),
(156, 'Mercedes-Benz', 'Pawel', 'Huelle', 'dtv 13302', 2005, '3-423-13302-3', 1),
(157, '�ber den Flu�', 'Andrzej', 'Stasiuk', 'es 2390', 2004, '3-518-12390-4', 1),
(158, 'Die Identit�t', 'Milan', 'Kundera', 'Fischer 14357', 2004, '3-596-14357-8', 1),
(159, 'Die Schwester', 'Jachym', 'Topol', 'st. 3656', 2004, '3-518-45656-3', 1),
(160, 'Pornographie', 'Witold', 'Gombrowicz', 'Hanser', 2004, '3-446-20558-6', 1),
(161, 'Fern und nah', 'Daniela', 'Fischerov�', 'Elfenbein', 2003, '3-932245-51-2', 1),
(162, 'Nachtarbeit', 'Jachym', 'Topol', 'Suhrkamp', 2003, '3-518-41477-1', 1),
(163, 'Seilschaften', 'Gy�rgy', 'Dalos', 'DuMont', 2002, '3-8321-6004-3', 1),
(164, 'Liquidation', 'Imre', 'Kert�sz', 'Suhrkamp', 2003, '3-518-41493-3', 1),
(165, 'Liquidation', 'Imre', 'Kert�sz', 'Der Audio Verlag', 2004, '3-89813-297-8', 1),
(166, 'Spurensucher', 'Imre', 'Kert�sz', 'BS 1357', 2003, '3-518-22357-7', 1),
(167, 'Spurensucher', 'Imre', 'Kert�sz', 'H�rbuch-\nHamburg', 2003, '3-89903-127-X', 1),
(168, 'Der Besucher', 'Gy�rgy', 'Konr�d', 'Suhrkamp', 1999, '3-518-41084-9', 1),
(169, 'Kettenbr�cke', 'Juliana (Hrsg.)', 'Wernitzer', 'dtv', 1999, '3-423-12690-6', 1),
(170, 'Silberregen', 'Pawel', 'Huelle', 'Rowohlt', 2000, '3-87134-343-9', 1),
(171, 'Feuerspiele', 'Andrzej', 'Szczypiorski', 'detebe 23327', 2002, '3-257-23327-2', 1),
(172, 'Die Fremden', 'Ivan', 'Cankar', 'Drava', 2004, '3-85435-431-2', 1),
(173, 'Herzflecken', 'Florjan', 'Lipus', 'Wieser', 2000, '3-85192-288-X', 1),
(174, 'Die Bafler', 'Bohumil', 'Hrabal', 'es 180', 1988, '3-518-10180-3', 1),
(175, 'Feuerwerk', 'Oliver', 'Friggieri', 'Kinzelbach', 2004, '3-927069-73-6', 1),
(176, 'Ferdydurke', 'Witold', 'Gombrowicz', 'Fischer ; 16434', 2004, '3-596-16434-6', 1),
(177, 'Frau Judit', 'Ivan', 'Cankar', 'Drava', 2004, '3-85435-409-6', 1),
(178, 'Der Scherz', 'Milan', 'Kundera', 'dtv 12521', 1998, '3-423-12521-7', 1),
(179, 'Land, Land', 'S�ndor', 'M�rai', 'Sp 3184', 2004, '3-492-23184-5', 1),
(180, 'Minotauros', 'Peter', 'N�das', 'rororo 22580', 1999, '3-499-22580-8', 1),
(181, 'Ehespiele', 'Maria', 'Nurowska', 'Fischer 14381', 1999, '3-596-14381-0', 1),
(182, 'Die Glut', 'S�ndor', 'M�rai', 'H�rbuch\nHamburg', 2000, '3-934120-61-X', 1),
(183, 'Die Glut', 'S�ndor', 'M�rai', 'SP 3313', 2004, '3-492-23313-9', 1),
(184, 'Baltikum', 'Rainer', 'Eisenschmid', 'Baedeker\n(Baedeker Allianz Reisef�hrer)', 2003, '3-87504-566-1', 1),
(185, 'Baltikum', '', '', 'TR-Verlagsunion', 2004, '3-8058-3662-7', 1),
(186, 'Hypnose', 'Hanna', 'Krall', 'Neue Kritik', 1997, '3-8015-0306-2', 1),
(187, 'Litauen', 'Marianna', 'Butensch�n', 'Beck\n(L�nder)', 2002, '3-406-44789-9', 1),
(188, 'Estland', '', '', 'Flechsig', 2004, '3-88189-467-5', 1),
(189, 'Fiasko', 'Stanislaw', 'Lem', 'st 3174', 2001, '3-518-39674-9', 1),
(190, 'Fiasko', 'Imre', 'Kert�sz', 'rororo 22909', 2002, '3-499-22909-9', 1),
(191, 'Azarel', 'K�roly', 'Pap', 'Luchterhand-Literaturverl.', 2004, '3-630-87157-7', 1),
(192, 'Polka', 'Manuela', 'Gretkowska', 'dtv 24399', 2004, '3-423-24399-6', 1),
(193, 'Gl�ck', 'Gy�rgy', 'Konr�d', 'st 3662', 2004, '3-518-45662-8', 1),
(194, 'Liebe', 'Peter', 'N�das', 'rororo 22579', 1999, '3-499-22579-4', 1),
(195, 'Neun', 'Andrzej', 'Stasiuk', 'st 3563', 2004, '3-518-45563-X', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `schlagworte`
--

CREATE TABLE IF NOT EXISTS `schlagworte` (
  `TAGID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  PRIMARY KEY  (`TAGID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Daten f�r Tabelle `schlagworte`
--

INSERT INTO `schlagworte` (`TAGID`, `INHALT`) VALUES
(1, 'Baltikum'),
(2, 'Geschichte'),
(3, 'Ungarn'),
(4, 'Estland'),
(5, 'Litauisch'),
(6, 'Sprachf�hrer'),
(7, 'Bildband'),
(8, 'Biographie'),
(9, 'Litauen'),
(10, 'Holocaust'),
(11, 'Geschichte'),
(12, 'Tschechien'),
(13, 'F�hrer'),
(14, 'Zypern'),
(15, 'Literatur'),
(16, 'Polen'),
(17, 'Hochseefischerei'),
(18, 'Slowenien'),
(19, 'Lettisch'),
(20, 'Estnisch'),
(21, 'Slowakei'),
(22, 'Lettland');

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `vorgang`
--

CREATE TABLE IF NOT EXISTS `vorgang` (
  `VORGANGSID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  PRIMARY KEY  (`VORGANGSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Daten f�r Tabelle `vorgang`
--

INSERT INTO `vorgang` (`VORGANGSID`, `INHALT`) VALUES
(1, 'Medium ausgeliehen'),
(2, 'Medium zur�ckgegeben'),
(3, 'Medium hinzugef�gt'),
(4, 'Medium entfernt'),
(5, 'Person hinzugef�gt'),
(6, 'Person entfernt'),
(7, 'Person abgemahnt'),
(8, 'Benutzer hinzugef�gt'),
(9, 'Benutzer gel�scht');

-- --------------------------------------------------------

--
-- Tabellenstruktur f�r Tabelle `zustand`
--

CREATE TABLE IF NOT EXISTS `zustand` (
  `ZUSTANDSID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  PRIMARY KEY  (`ZUSTANDSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Daten f�r Tabelle `zustand`
--

INSERT INTO `zustand` (`ZUSTANDSID`, `INHALT`) VALUES
(1, 'Neuwertig'),
(2, 'Fast neuwertig'),
(3, 'leicht verschmutzt'),
(4, 'leicht besch�digt'),
(5, 'stark verschmutzt'),
(6, 'stark besch�digt');

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `beinhaltet`
--
ALTER TABLE `beinhaltet`
  ADD CONSTRAINT `FK_BEINHALTET2` FOREIGN KEY (`MEDIENID`) REFERENCES `medium` (`MEDIENID`),
  ADD CONSTRAINT `FK_BEINHALTET` FOREIGN KEY (`TAGID`) REFERENCES `schlagworte` (`TAGID`);

--
-- Constraints der Tabelle `exemplar`
--
ALTER TABLE `exemplar`
  ADD CONSTRAINT `FK_GEHOERT_ZU` FOREIGN KEY (`MEDIENID`) REFERENCES `medium` (`MEDIENID`),
  ADD CONSTRAINT `FK_HAT` FOREIGN KEY (`ZUSTANDSID`) REFERENCES `zustand` (`ZUSTANDSID`),
  ADD CONSTRAINT `FK_LEIHT_AUS` FOREIGN KEY (`BENUTZERID`) REFERENCES `ausleiher` (`BENUTZERID`);

--
-- Constraints der Tabelle `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `FK_LOGGT` FOREIGN KEY (`EXEMPLARID`) REFERENCES `exemplar` (`EXEMPLARID`),
  ADD CONSTRAINT `FK_LOGGT2` FOREIGN KEY (`BENUTZERID`) REFERENCES `ausleiher` (`BENUTZERID`),
  ADD CONSTRAINT `FK_LOGGT3` FOREIGN KEY (`ANWENDERNAME`) REFERENCES `anwender` (`ANWENDERNAME`),
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`VORGANGSID`) REFERENCES `vorgang` (`VORGANGSID`);
