-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 24. März 2009 um 11:39
-- Server Version: 5.0.67
-- PHP-Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Datenbank: `bibliotheksverwaltung`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `anwender`
--

CREATE TABLE IF NOT EXISTS `anwender` (
  `ANWENDERNAME` char(32) NOT NULL,
  `PASSWORT` char(64) NOT NULL,
  `hierarchiestufe` tinyint(1) NOT NULL default '1',
  `AKTIV` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`ANWENDERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `anwender`
--

INSERT INTO `anwender` (`ANWENDERNAME`, `PASSWORT`, `hierarchiestufe`, `AKTIV`) VALUES
('m.beier', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1),
('s.blaurock', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1),
('s.terzyk', 'ea2b2676c28c0db26d39331a336c6b92', 1, 1),
('test', 'test', 0, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ausleiher`
--

CREATE TABLE IF NOT EXISTS `ausleiher` (
  `AUSLEIHERID` int(11) NOT NULL auto_increment,
  `VORNAME` char(32) default NULL,
  `NACHNAME` char(32) default NULL,
  `STRASSE` char(32) default NULL,
  `HAUSNUMMER` char(8) default NULL,
  `PLZ` varchar(5) default NULL,
  `STADT` char(32) default NULL,
  `AKTIV` tinyint(1) default NULL,
  PRIMARY KEY  (`AUSLEIHERID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Daten für Tabelle `ausleiher`
--

INSERT INTO `ausleiher` (`AUSLEIHERID`, `VORNAME`, `NACHNAME`, `STRASSE`, `HAUSNUMMER`, `PLZ`, `STADT`, `AKTIV`) VALUES
(1, 'Peter', 'Hirsch', 'Ringbahnstraße', '12', '10711', 'Berlin', 1),
(2, 'Simon', 'Jelkes', 'Belziger Straße', '45', '10823', 'Berlin', 1),
(3, 'Daniel', 'Berger', 'Quedlinburgerstraße', '2', '10589', 'Berlin', 1),
(4, 'Nico', 'Fischer', 'Heidekampweg', '87', '12437', 'Berlin', 1),
(5, 'Andreas', 'Falk', 'Lichtenrader Damm', '49', '12305', 'Berlin', 1),
(6, 'Simon', 'Kupper', 'Birkbuschstraße', '76', '12167', 'Berlin', 1),
(7, 'Abdul', 'Cemekoglu', 'Gleimstraße', '10', '10437', 'Berlin', 1),
(8, 'Roland', 'Geldmacher', 'Samariterstraße', '36', '10247', 'Berlin', 1),
(9, 'Thomas', 'Breaker', 'Mahlsdorfer Straße', '59', '15366', 'Hoppegarten', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `beinhaltet`
--

CREATE TABLE IF NOT EXISTS `beinhaltet` (
  `TAGID` int(11) NOT NULL,
  `MEDIENID` int(11) NOT NULL,
  PRIMARY KEY  (`TAGID`,`MEDIENID`),
  KEY `BEINHALTET_FK` (`TAGID`),
  KEY `BEINHALTET2_FK` (`MEDIENID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `beinhaltet`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `exemplar`
--

CREATE TABLE IF NOT EXISTS `exemplar` (
  `EXEMPLARID` int(11) NOT NULL auto_increment,
  `ZUSTANDSID` int(11) default NULL,
  `AUSLEIHERID` int(11) default NULL,
  `MEDIENID` int(11) default NULL,
  `RUECKGABEDATUM` date default NULL,
  `VERLAENGERUNG` int(11) default NULL,
  `AKTIV` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`EXEMPLARID`),
  KEY `LEIHT_AUS_FK` (`AUSLEIHERID`),
  KEY `HAT_FK` (`ZUSTANDSID`),
  KEY `GEHOERT_ZU_FK` (`MEDIENID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Daten für Tabelle `exemplar`
--

INSERT INTO `exemplar` (`EXEMPLARID`, `ZUSTANDSID`, `AUSLEIHERID`, `MEDIENID`, `RUECKGABEDATUM`, `VERLAENGERUNG`, `AKTIV`) VALUES
(1, 1, 3, 2, '2009-03-24', 0, 1),
(2, 3, 1, 5, '2009-03-17', 1, 1),
(3, 2, NULL, 143, '0000-00-00', 0, 1),
(4, 1, 8, 122, '2009-04-15', 0, 1),
(5, 1, NULL, 7, NULL, 0, 1),
(6, 1, NULL, 5, '3909-04-11', 0, 1),
(7, 1, 1, 5, '2009-04-12', NULL, 1),
(17, 1, NULL, 15, NULL, NULL, 1),
(18, 1, NULL, 5, NULL, NULL, 1),
(19, 1, NULL, 5, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `konfiguration`
--

CREATE TABLE IF NOT EXISTS `konfiguration` (
  `NAME` char(64) NOT NULL,
  `WERT` char(128) NOT NULL,
  PRIMARY KEY  (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `konfiguration`
--

INSERT INTO `konfiguration` (`NAME`, `WERT`) VALUES
('ausleihdauer', '30'),
('ausleiher_prikey', 'ausleiherid'),
('ausleiher_tabelle', 'ausleiher'),
('medium_prikey', 'medienid'),
('medium_tabelle', 'medium'),
('verlaengerung', '2');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `LOGID` bigint(20) NOT NULL auto_increment,
  `VORGANGSID` int(11) default NULL,
  `AUSLEIHERID` int(11) default NULL,
  `ANWENDERNAME` char(32) default NULL,
  `EXEMPLARID` int(11) default NULL,
  `LOGDATUM` datetime NOT NULL,
  `KOMMENTAR` char(128) default NULL,
  PRIMARY KEY  (`LOGID`),
  KEY `RELATIONSHIP_1_FK` (`VORGANGSID`),
  KEY `LOGGT_FK` (`EXEMPLARID`),
  KEY `LOGGT3_FK` (`ANWENDERNAME`),
  KEY `LOGGT2_FK` (`AUSLEIHERID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Daten für Tabelle `log`
--

INSERT INTO `log` (`LOGID`, `VORGANGSID`, `AUSLEIHERID`, `ANWENDERNAME`, `EXEMPLARID`, `LOGDATUM`, `KOMMENTAR`) VALUES
(1, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(2, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(3, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(4, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(5, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(6, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(7, 2, NULL, 'test', 7, '2009-03-13 00:00:00', NULL),
(8, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(9, 2, NULL, 'test', 7, '2009-03-13 00:00:00', NULL),
(10, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(11, 2, NULL, 'test', 7, '2009-03-13 00:00:00', NULL),
(12, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(13, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(14, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(15, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(16, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(17, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(18, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(19, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(20, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(21, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(22, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(23, 2, 1, 'test', 7, '2009-03-13 00:00:00', NULL),
(24, 1, 1, 'test', 7, '2009-03-13 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `medium`
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
-- Daten für Tabelle `medium`
--

INSERT INTO `medium` (`MEDIENID`, `TITEL`, `AUTORVORNAME`, `AUTORNACHNAME`, `VERLAG`, `ERSCHEINUNGSJAHR`, `ISBN`, `AKTIV`) VALUES
(1, 'Die baltischen Länder : Estland, Lettland, Litauen vom Mittelalter bis zur Gegenwart', 'Michael', 'Garleff', 'Pustet', 2001, '3-7917-1770-7', 1),
(2, 'Wie ich lernte, die Frauen zu lieben: Die amourösen Erinnerungen des András Vajda', 'Stephen', 'Vzinczey', 'SchirmerGraf', 2004, '3-86555-008-8', 1),
(3, 'Ich liebte einen Russen: Zur Erinnerung an die schneereichen Winter der Kindheit', 'Maimu', 'Berg', 'Gollenstein', 1998, '3-930008-83-1', 1),
(4, 'Litauisch Wort für Wort : das ganze Buch auf CD-ROM plus Audio-Aussprachetrainer', 'Katrin', 'Jähnert', 'Reise Know-How', 2004, '3-8317-6071-3', 1),
(5, 'Von den Ufern der Memel ins Ungewisse : Eine Jugend im Schatten des Holocaust', 'Zwi', 'Katz', 'Pendo', 2002, '3-85842-490-0', 1),
(6, 'Reise in das Baltikum : auf Spurensuche in Estland, Lettland und Litauen.', 'Michael', 'Welder', 'Rautenberg', 2002, '3-8003-3028-8', 1),
(7, 'Estland entdecken : skandinavische Impressionen im nördlichen Baltikum', 'Klaus', 'Schameitat', 'Trescher', 2003, '3-89794-036-1', 1),
(8, 'Und sie feierten Hochzeit vierzig Tage und vierzig Nächte lang', 'Niki', 'Marangou', 'Romiosini', 2001, '3-929889-59-5', 1),
(9, 'Baltische Staaten : Estland, Lettland, Litauen, Kaliningrad', 'Torbus', 'Tomasz', 'Nelles', 2004, '3-88618-801-9', 1),
(10, 'Ein Held seiner Zeit : Die Bekenntnisse des Kornél Esti', 'Deszö', 'Kosztolànyi', 'Rowohlt', 2004, '3-87134-489-3', 1),
(11, 'Liebende für eine Nacht, Liebende für einen Tag', 'Ivan', 'Klima', 'Hanser', 2002, '3-446-17227-0', 1),
(12, 'Hordubal. Der Meteor. Ein gewöhnliches Leben', 'Karel', 'Capek', 'DVA', 1999, '3-421-05233-6', 1),
(13, 'Die Abenteuer des braven Soldaten Schwejk', 'Jaroslav', 'Hasek', 'Random House Audio', 2001, '3-89830-149-4', 1),
(14, 'Die Abenteuer des braven Soldaten Schwejk', 'Jaroslav', 'Hasek', 'AtV 1928', 2003, '3-7466-1928-9', 1),
(15, 'Freiheitsübungen : Und andere kleine Prosa', 'Peter', 'Nádas', 'Berlin Verlag', 2004, '3-8270-0533-7', 1),
(16, 'Litauen : ein literarischer Reisebegleiter', 'Claudia', 'Sinnig', 'Insel', 2002, '3-458-34544-2', 1),
(17, 'Freundinnen aus dem Haus der Traurigkeit', 'Eva', 'Kanturkova', 'DVA', 2003, '3-421-05249-2', 1),
(18, 'Die unerträgliche Leichtigkeit des Seins', 'Milan', 'Kundera', 'Fischer 5992', 2002, '3-596-25992-4', 1),
(19, 'Der Doppelgänger und andere Geschichten', 'Slawomir', 'Mrozek', 'Diogenes', 2000, '3-257-06242-7', 1),
(20, 'Warten auf Dunkelheit, Warten auf Licht', 'Ivan', 'Klima', 'dtv 12742', 2000, '3-423-12742-2', 1),
(21, 'Ich habe den englischen König bedient', 'Bohumil', 'Hrabal', 'st 3502', 2003, '3-518-45502-8', 1),
(22, 'Niki oder die Geschichte eines Hundes', 'Tibor', 'Déry', 'Das Arsenal', 2001, '3-931109-26-7', 1),
(23, 'Kaddisch für ein nichtgeborenes Kind', 'Imre', 'Kertész', 'rororo 22574', 2002, '3-499-22574-3', 1),
(24, 'Im Dienst der Großen Hochseefischerei', 'Richard', 'Neu', 'Hauschild', 2002, '3-89757-144-7', 1),
(25, 'Baltikum : Estland, Lettland, Litauen', 'Jan', 'Pallokat', 'Mairs Geogra-phischer Verl. \n(Marco Polo)', 2003, '3-8297-0258-2', 1),
(26, '...doch die Märchen sprechen Deutsch', 'Ota', 'Filip', 'Langen-Müller', 1996, '3-7844-2584-4', 1),
(27, 'Das Buch vom Lachen und Vergessen', 'Milan', 'Kundera', 'dtv 12790', 2000, '3-423-12790-2', 1),
(28, 'Die Legende von den Tränengauklern', 'Laszlo', 'Darvasi', 'Suhrkamp', 2001, '3-518-41284-1', 1),
(29, 'Ich dachte an die goldenen Zeiten', 'Bohumil', 'Hrabal', 'Suhrkamp', 1999, '3-518-41048-2', 1),
(30, 'Ich bin eine Fliege beim Minister', 'István', 'Eörsi', 'Wieser', 2004, '3-85129-457-2', 1),
(31, 'Das Buch der lächerlichen Liebe', 'Milan', 'Kundera', 'Fischer 9264', 2004, '3-596-29264-6', 1),
(32, 'Geschichte der baltischen Länder', 'Ralph', 'Tuchtenhagen', 'Beck\n(Beck''sche Reihe)\n', 2005, '3-406-50855-3', 1),
(33, 'Die phantastischen Erzählungen', 'Stanislaw', 'Lem', 'st 1525', 2003, '3-518-38025-7', 1),
(34, 'Ein anderes Leben gibt es nicht', 'Maria', 'Nurowska', 'Fischer 13615', 2001, '3-596-13615-6', 1),
(35, 'Das Leben des Balthasar Rüssow', 'Jaan', 'Kross', 'dtv 12563', 1999, '3-423-12563-2', 1),
(36, 'Der Mensch auf der Landstraße', 'Jan', 'Cep', 'DVA', 2003, '3-421-05246-8', 1),
(37, 'Der Teufel auf dem Kirchturm', '\nMarek', 'Lawrynowicz', 'dtv 13191', 2004, '3-423-13191-8', 1),
(38, 'Die lange Welle hinterm Kiel', 'Pavel', 'Kohout', 'btb 72965', 2002, '3-442-72965-3', 1),
(39, 'Litauisch Aussprache-Trainer', 'Katrin', 'Jähnert', 'Reise Know-How', 2004, '3-8317-6080-2', 1),
(40, 'Lolo und andere Geschichten', 'Slawomir', 'Mrozek', 'Diogenes', 2000, '3-257-06243-5', 1),
(41, 'Das Haus der Barmherzigkeit', 'Ivan', 'Cankar', 'Drava', 1996, '3-85435-257-3', 1),
(42, 'Siebenmal in der Hauptrolle', 'Egon', 'Hostovsky', 'DVA', 2004, '3-421-05252-2', 1),
(43, 'Die Hilfsverben des Herzens', 'Péter', 'Esterházy', 'BS 1374', 2004, '3-518-22374-7', 1),
(44, 'Die Nacht vor der Scheidung', 'Sándor', 'Márai', 'Hörbuch\nHamburg', 2004, '3-89903-176-8', 1),
(45, 'Die Nacht vor der Scheidung', 'Sándor', 'Márai', 'Piper', 2003, '3-492-04287-2', 1),
(46, 'Lettisch Aussprache-Trainer', 'Bernardo', 'Christophe', 'Reise Know-How', 2003, '3-8317-6088-8', 1),
(47, 'Roman eines Schicksallosen', 'Imre', 'Kertész', 'rororo 22576', 2004, '3-499-22576-X', 1),
(48, 'Bekenntnisse eines Bürgers', 'Sándor', 'Márai', 'SP 3081', 2002, '3-492-23081-4', 1),
(49, 'Das Vermächtnis der Eszter', 'Sándor', 'Márai', 'SP 3511', 2002, '3-492-23511-5', 1),
(50, 'Das Wunder des San Gennaro', 'Sándor', 'Márai', 'Sp 7044', 2004, '3-492-27044-1', 1),
(51, 'Ende eines Familienromans.', 'Peter', 'Nádas', 'rororo 22582', 1999, '3-499-22582-4', 1),
(52, 'Die letzte Fenstergiraffe', 'Péter', 'Zilahy', 'Eichborn', 2004, '3-8218-0755-5', 1),
(53, 'Tanz auf fremder Hochzeit', 'Hanna', 'Krall', 'Neue Kritik', 1993, '3-8015-0265-1', 1),
(54, 'Die schöne Frau Seidenman', 'Andrzej', 'Szczypiorski', 'Diogenes', 2000, '3-257-21945-8', 1),
(55, 'Ich ging nach einem Regen', 'Michael', 'Adams', 'Gollenstein', 2000, '3-933389-28-3', 1),
(56, 'Sergijs letzte Versuchung', 'Jani', 'Virk', 'Wieser', 2004, '3-85129-455-6', 1),
(57, 'Die invaliden Geschwister', 'Egon', 'Bondy', 'Elfenbein', 1998, '3-932245-25-3', 1),
(58, 'Die Hundejäger von Lojang', 'Laszlo', 'Darvasi', 'Suhrkamp', 2003, '3-518-41427-5', 1),
(59, 'Estnisch für Globetrotter', 'Irja', 'Grönholm', 'Reise Know-How', 0, '3-89416-120-5', 1),
(60, 'Die Frauen von Wesenberg', 'Jaan', 'Kross', 'Hanser', 1997, '3-446-19120-8', 1),
(61, 'Wie Laub von einem Baum', 'Peter (Hrsg.)', 'Zajac', 'Gollenstein', 1994, '3-930008-07-6', 1),
(62, ' Der siebente Lebenslauf', 'Ota', 'Filip', 'Herbig', 2001, '3-7766-2234-2', 1),
(63, 'Richter in eigener Sache', 'Ivan', 'Klima', 'Zsolnay', 2002, '3-552-04831-6', 1),
(64, 'Die Rache der Baumeister', 'Milos', 'Urban', 'rororo 23342', 2003, '3-499-23342-8', 1),
(65, 'Litauisch Wort für Wort', 'Katrin', 'Jähnert', 'Reise Know-How', 2001, '3-89416-244-9', 1),
(66, 'Der Verrückte des Zaren', 'Jaan', 'Kross', 'dtv 20665', 2003, '3-423-20655-1', 1),
(67, 'Da ist kein Fluss mehr', 'Hanna', 'Krall', 'btb 72631', 2001, '3-442-72631-X', 1),
(68, 'Der Himmel unter Berlin', 'Jaroslav', 'Rudis', 'Rowohlt', 2004, '3-87134-496-6', 1),
(69, 'Der Bäcker Jan Marhoul', 'Vladislav', 'Vancura', 'DVA', 2000, '3-421-05237-9', 1),
(70, 'Litauen mit Kaliningrad', 'Günther', 'Schäfer', 'Reise Know-How Verlag Rump', 2003, '3-8317-1152-6', 1),
(71, 'Lettisch Wort für Wort', 'Bernardo', 'Christophe', 'Reise Know-How', 2002, '3-89416-273-2', 1),
(72, 'Estnisch Wort für Wort', 'Irja', 'Grönholm', 'Reise Know-How', 1999, '3-89416-245-7', 1),
(73, 'Grashalme aus Lettland', 'Miervaldis', 'Birze', 'edition memoria', 2000, '3-930353-12-1', 1),
(74, 'Lehrjahre des Gammelns', '\nMarek', 'Lawrynowicz', 'Beck', 2002, '3-406-48966-4', 1),
(75, 'Der Mensch vom Mars :', 'Stanislaw', 'Lem', 'st.2145', 2003, '3-518-38645-X', 1),
(76, 'Das Leben für Anfänger', 'Slawomir', 'Mrozek', 'Diogenes', 2004, '3-257-06453-5', 1),
(77, 'Der russische Geliebte', 'Maria', 'Nurowska', 'Fischer 14876', 2003, '3-596-14876-6', 1),
(78, 'Galizische Geschichten', 'Andrzej', 'Stasiuk', 'st 3620', 2004, '3-518-45620-2', 1),
(79, 'Amerikanischer Whiskey', 'Andrzej', 'Szczypiorski', 'detebe 22415', 2000, '3-257-22415-X', 1),
(80, 'Selbstporträt mit Frau', 'Andrzej', 'Szczypiorski', 'detebe 22871', 1996, '3-257-22871-6', 1),
(81, 'Allein gegen die Nacht', 'Dominik', 'Tatarka', 'Wieser', 2004, '3-85129-469-6', 1),
(82, 'Das andere Weihnachten', 'Ota', 'Filip', 'Langen-Müller', 2004, '3-7844-2972-6', 1),
(83, 'Sternstunde der Mörder', 'Pavel', 'Kohout', 'btb 72175', 1997, '3-442-72175-X', 1),
(84, 'Das Leben ist anderswo', 'Milan', 'Kundera', 'dtv 12730', 2000, '3-423-12730-9', 1),
(85, 'Ein Hund mit Charakter', 'Sándor', 'Márai', 'SP 4009', 2004, '3-492-24009-7', 1),
(86, 'Die Welt hinter Dukla', 'Andrzej', 'Stasiuk', 'Suhrkamp', 2001, '3-518-41205-1', 1),
(87, 'Weiße Nächte mit Hahn', 'Manfred (Hrsg.)', 'Jähnichen', 'Gollenstein', 1996, '3-930008-36-X', 1),
(88, 'Blut ist kein Wasser', 'Josef', 'Jedlicka', 'DVA', 2002, '3-421-05244-1', 1),
(89, 'Die Pendragon-Legende', 'Antal', 'Szerb', 'dtv 24425', 2004, '3-423-24425-9', 1),
(90, 'Afrikanisches Fieber', 'Ryszard', 'Kapuczinski', 'Eichborn', 1999, '3-8218-4483-3', 1),
(91, 'Berühmte Liebespaare', 'Boleslaw', 'Lubosz', 'Gollenstein', 1996, '3-930008-35-1', 1),
(92, 'Den Schatten fangen', 'Andrzej', 'Szczypiorski', 'detebe 22789', 2000, '3-257-22789-2', 1),
(93, 'Der Teufel im Graben', 'Andrzej', 'Szczypiorski', 'detebe 22739', 1995, '3-257-22739-6', 1),
(94, 'Nacht, Tag und Nacht', 'Andrzej', 'Szczypiorski', 'detebe 22635', 2000, '3-257-22635-7', 1),
(95, 'Ur und andere Zeiten', 'Olga', 'Togarczuk', 'Berlin Verlag', 2000, '3-8270-0340-7', 1),
(96, 'Die wunderbaren Wege', 'Magdalena', 'Sadlon', 'dtv 13101', 2003, '3-423-13102-2', 1),
(97, 'Fröhliches Begräbnis', 'Tibor', 'Déry', 'Das Arsenal', 1995, '3-921810-71-X', 1),
(98, 'Die englische Flagge', 'Imre', 'Kertész', 'rororo 22572', 2002, '3-499-22572-7', 1),
(99, 'Die Gräfin von Parma', 'Sándor', 'Márai', 'SP 4040', 2004, '3-492-24040-2', 1),
(100, 'Wandlungen einer Ehe', 'Sándor', 'Márai', 'Hörbuch\nHamburg', 2003, '3-89903-129-6', 1),
(101, 'Wandlungen einer Ehe', 'Sándor', 'Márai', 'SP 4167', 2004, '3-492-24167-0', 1),
(102, 'Buch der Erinnerung', 'Peter', 'Nádas', 'rororo 22581', 1999, '3-499-22581-6', 1),
(103, 'Sterne der Eiszeit', 'Renata', 'Serelyte', 'Rowohlt Berlin', 2002, '3-87134-457-5', 1),
(104, 'Taghaus, Nachthaus', 'Olga', 'Togarczuk', 'dtv 13166', 2004, '3-423-13166-7', 1),
(105, 'Hochzeiten im Hause', 'Bohumil', 'Hrabal', 'st. 2414', 1995, '3-518-38914-9', 1),
(106, 'Meine ersten Lieben', 'Ivan', 'Klima', 'dtv 12309', 1997, '3-423-12309-5', 1),
(107, 'Die Unsterblichkeit', 'Milan', 'Kundera', 'Fischer 10672', 2004, '3-596-10672-9', 1),
(108, 'Der Mann aus Zelary', 'Kveta', 'Legátova', 'dtv 24420', 2004, '3-423-24420-8', 1),
(109, 'Die traurigen Augen', 'Ivan', 'Olbracht', 'DVA', 2001, '3-421-05569-6', 1),
(110, 'Wir fünf und Jumbo', 'Karel', 'Polacek', 'DVA', 2001, '3-421-05239-5', 1),
(111, 'Leben mit dem Stern', 'Jiri', 'Weil', 'DVA', 2000, '3-421-05238-7', 1),
(112, 'Die jungen Rebellen', 'Sándor', 'Márai', 'Hörbuch\nHamburg', 2001, '3-89903-017-6', 1),
(113, 'Die jungen Rebellen', 'Sándor', 'Márai', 'SP 3898', 2003, '3-492-23898-X', 1),
(114, 'Dichtung und Prosa', 'Adam', 'Mickiewicz', 'Suhrkamp', 2000, '3-518-40665-5', 1),
(115, 'Der Sünder Lennart', 'Ivan', 'Cankar', 'Drava', 2002, '3-85435-376-6', 1),
(116, 'Eine Frau besorgen', 'Laszlo', 'Darvasi', 'es 2448', 2003, '3-518-12448-X', 1),
(117, 'Harmonia Caelestis', 'Péter', 'Esterházy', 'BVT', 2004, '3-8333-0114-7', 1),
(118, 'Detektivgeschichte', 'Imre', 'Kertész', 'Rowohlt', 2004, '3-498-03525-8', 1),
(119, 'Ich – ein anderer', 'Imre', 'Kertész', 'rororo 22573', 2002, '3-499-22573-5', 1),
(120, 'Reise im Mondlicht', 'Antal', 'Szerb', 'Hörbuch\nHamburg', 2004, '3-89903-160-1', 1),
(121, 'Reise im Mondlicht', 'Antal', 'Szerb', 'dtv 24370', 2004, '3-423-24370-8', 1),
(122, 'Frieden auf Erden', 'Stanislaw', 'Lem', 'st 1574', 2004, '3-518-38074-5', 1),
(123, 'Zum starken Engel', 'Jerzy', 'Pilch', 'Luchterhand Literaturverlag', 2002, '3-630-87131-3', 1),
(124, 'Aus fremdem Leben', 'Ivan', 'Cankar', 'Drava', 1997, '3-85435-279-4', 1),
(125, 'Luzifers Lächeln', 'Drago', 'Jancar', 'Wieser', 1996, '3-85129-159-X', 1),
(126, 'Gottes Regenbogen', 'Jaroslav', 'Durych', 'DVA', 1999, '3-421-05232-8', 1),
(127, 'Ich – ein anderer', 'Imre', 'Kertész', 'Der Hör Verlag', 2003, '3-89940-118-2', 1),
(128, 'Die Astronauten', 'Stanislaw', 'Lem', 'st 441', 2003, '3-518-36941-5', 1),
(129, 'Das Tal der Issa', 'Czeslaw', 'Milosz', 'Eichborn', 2000, '3-8218-4709-3', 1),
(130, 'Briefe der Liebe', 'Maria', 'Nurowska', 'Fischer 12500', 2003, '3-596-12500-6', 1),
(131, 'Fräulein Niemand', 'Tomek', 'Tryzna', 'btb 72500', 1999, '3-442-72500-3', 1),
(132, 'Rauschen im Kopf', 'Drago', 'Jancar', 'dtv 13051', 2003, '3-423-13051-2', 1),
(133, 'Ein Liebessommer', 'Ivan', 'Klima', 'dtv 12339', 1997, '3-423-12339-7', 1),
(134, 'Die Unwissenheit', 'Milan', 'Kundera', 'Fischer 15128', 2003, '3-596-15128-7', 1),
(135, 'Die Beschneidung', 'György', 'Dalos', 'st 3052', 1999, '3-518-39552-1', 1),
(136, 'Das Buch Hrabals', 'Péter', 'Esterházy', 'BVT', 2004, '3-8333-0032-9', 1),
(137, 'Sirene der Adria', 'Gábor', 'Görgey', 'SALON-Literaturverl.', 2004, '3-9809635-0-0', 1),
(138, 'Galeerentagebuch', 'Imre', 'Kertész', 'rororo 22575', 2002, '3-499-22575-1', 1),
(139, 'Himmel und Erde', 'Sándor', 'Márai', 'SP 3714', 2004, '3-492-23714-2', 1),
(140, 'Baltische Länder', 'Claudia', 'Marenbach', 'Müller', 2003, '3-89953-113-2', 1),
(141, 'Die Gouvernante', 'Stefan', 'Chwin', 'rororo 23362', 2003, '3-499-23362-2', 1),
(142, 'Tod in Danzig', 'Stefan', 'Chwin', 'rororo 22623', 2001, '3-499-22623-2', 1),
(143, 'Spanische Augen', 'Maria', 'Nurowska', 'Fischer 13194', 2002, '3-596-13194-4', 1),
(144, 'Der weisse Rabe', 'Andrzej', 'Stasiuk', 'rororo 22692', 2000, '3-499-22692-8', 1),
(145, 'Liebesgespräche', 'Ivan', 'Klima', 'Zsolnay', 2002, '3-552-05184-9', 1),
(146, 'Abschiedswalzer', 'Milan', 'Kundera', 'dtv 12429', 1998, '3-423-12429-6', 1),
(147, 'Die Langsamkeit', 'Milan', 'Kundera', 'Fischer 13088', 2004, '3-596-13088-3', 1),
(148, 'Die Besessenen', 'Witold', 'Gombrowicz', 'dtv 11444', 1992, '3-423-11444-4', 1),
(149, 'Robotermärchen', 'Stanislaw', 'Lem', 'st 856', 2004, '3-518-37356-0', 1),
(150, 'Robotermärchen', 'Stanislaw', 'Lem', 'Hörbuchproduktionen', 2001, '3-89614-236-4', 1),
(151, 'Fin de siècle', 'Peter (Hrsg.)', 'Demetz', 'DVA', 2004, '3-421-05251-4', 1),
(152, 'Der Gottsucher', 'György', 'Dalos', 'st 3251', 2001, '3-518-39751-6', 1),
(153, 'Buch der Väter', 'Miklós', 'Vámos', 'btb', 2004, '3-442-75118-7', 1),
(154, 'Die Regenhexe', 'Jurga', 'Ivanauskaite', 'dtv 13132', 2004, '3-423-13132-2', 1),
(155, 'Tans-Atlantik', 'Witold', 'Gombrowicz', 'Fischer 16438', 2004, '3-596-16438-9', 1),
(156, 'Mercedes-Benz', 'Pawel', 'Huelle', 'dtv 13302', 2005, '3-423-13302-3', 1),
(157, 'Über den Fluß', 'Andrzej', 'Stasiuk', 'es 2390', 2004, '3-518-12390-4', 1),
(158, 'Die Identität', 'Milan', 'Kundera', 'Fischer 14357', 2004, '3-596-14357-8', 1),
(159, 'Die Schwester', 'Jachym', 'Topol', 'st. 3656', 2004, '3-518-45656-3', 1),
(160, 'Pornographie', 'Witold', 'Gombrowicz', 'Hanser', 2004, '3-446-20558-6', 1),
(161, 'Fern und nah', 'Daniela', 'Fischerová', 'Elfenbein', 2003, '3-932245-51-2', 1),
(162, 'Nachtarbeit', 'Jachym', 'Topol', 'Suhrkamp', 2003, '3-518-41477-1', 1),
(163, 'Seilschaften', 'György', 'Dalos', 'DuMont', 2002, '3-8321-6004-3', 1),
(164, 'Liquidation', 'Imre', 'Kertész', 'Suhrkamp', 2003, '3-518-41493-3', 1),
(165, 'Liquidation', 'Imre', 'Kertész', 'Der Audio Verlag', 2004, '3-89813-297-8', 1),
(166, 'Spurensucher', 'Imre', 'Kertész', 'BS 1357', 2003, '3-518-22357-7', 1),
(167, 'Spurensucher', 'Imre', 'Kertész', 'Hörbuch-\nHamburg', 2003, '3-89903-127-X', 1),
(168, 'Der Besucher', 'György', 'Konrád', 'Suhrkamp', 1999, '3-518-41084-9', 1),
(169, 'Kettenbrücke', 'Juliana (Hrsg.)', 'Wernitzer', 'dtv', 1999, '3-423-12690-6', 1),
(170, 'Silberregen', 'Pawel', 'Huelle', 'Rowohlt', 2000, '3-87134-343-9', 1),
(171, 'Feuerspiele', 'Andrzej', 'Szczypiorski', 'detebe 23327', 2002, '3-257-23327-2', 1),
(172, 'Die Fremden', 'Ivan', 'Cankar', 'Drava', 2004, '3-85435-431-2', 1),
(173, 'Herzflecken', 'Florjan', 'Lipus', 'Wieser', 2000, '3-85192-288-X', 1),
(174, 'Die Bafler', 'Bohumil', 'Hrabal', 'es 180', 1988, '3-518-10180-3', 1),
(175, 'Feuerwerk', 'Oliver', 'Friggieri', 'Kinzelbach', 2004, '3-927069-73-6', 1),
(176, 'Ferdydurke', 'Witold', 'Gombrowicz', 'Fischer ; 16434', 2004, '3-596-16434-6', 1),
(177, 'Frau Judit', 'Ivan', 'Cankar', 'Drava', 2004, '3-85435-409-6', 1),
(178, 'Der Scherz', 'Milan', 'Kundera', 'dtv 12521', 1998, '3-423-12521-7', 1),
(179, 'Land, Land', 'Sándor', 'Márai', 'Sp 3184', 2004, '3-492-23184-5', 1),
(180, 'Minotauros', 'Peter', 'Nádas', 'rororo 22580', 1999, '3-499-22580-8', 1),
(181, 'Ehespiele', 'Maria', 'Nurowska', 'Fischer 14381', 1999, '3-596-14381-0', 1),
(182, 'Die Glut', 'Sándor', 'Márai', 'Hörbuch\nHamburg', 2000, '3-934120-61-X', 1),
(183, 'Die Glut', 'Sándor', 'Márai', 'SP 3313', 2004, '3-492-23313-9', 1),
(184, 'Baltikum', 'Rainer', 'Eisenschmid', 'Baedeker\n(Baedeker Allianz Reiseführer)', 2003, '3-87504-566-1', 1),
(185, 'Baltikum', '', '', 'TR-Verlagsunion', 2004, '3-8058-3662-7', 1),
(186, 'Hypnose', 'Hanna', 'Krall', 'Neue Kritik', 1997, '3-8015-0306-2', 1),
(187, 'Litauen', 'Marianna', 'Butenschön', 'Beck\n(Länder)', 2002, '3-406-44789-9', 1),
(188, 'Estland', '', '', 'Flechsig', 2004, '3-88189-467-5', 1),
(189, 'Fiasko', 'Stanislaw', 'Lem', 'st 3174', 2001, '3-518-39674-9', 1),
(190, 'Fiasko', 'Imre', 'Kertész', 'rororo 22909', 2002, '3-499-22909-9', 1),
(191, 'Azarel', 'Károly', 'Pap', 'Luchterhand-Literaturverl.', 2004, '3-630-87157-7', 1),
(192, 'Polka', 'Manuela', 'Gretkowska', 'dtv 24399', 2004, '3-423-24399-6', 1),
(193, 'Glück', 'György', 'Konrád', 'st 3662', 2004, '3-518-45662-8', 1),
(194, 'Liebe', 'Peter', 'Nádas', 'rororo 22579', 1999, '3-499-22579-4', 1),
(195, 'Neun', 'Andrzej', 'Stasiuk', 'st 3563', 2004, '3-518-45563-X', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `schlagworte`
--

CREATE TABLE IF NOT EXISTS `schlagworte` (
  `TAGID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  PRIMARY KEY  (`TAGID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Daten für Tabelle `schlagworte`
--

INSERT INTO `schlagworte` (`TAGID`, `INHALT`) VALUES
(1, 'Baltikum'),
(2, 'Geschichte'),
(3, 'Ungarn'),
(4, 'Estland'),
(5, 'Litauisch'),
(6, 'Sprachführer'),
(7, 'Bildband'),
(8, 'Biographie'),
(9, 'Litauen'),
(10, 'Holocaust'),
(11, 'Geschichte'),
(12, 'Tschechien'),
(13, 'Führer'),
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
-- Tabellenstruktur für Tabelle `vorgang`
--

CREATE TABLE IF NOT EXISTS `vorgang` (
  `VORGANGSID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  PRIMARY KEY  (`VORGANGSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Daten für Tabelle `vorgang`
--

INSERT INTO `vorgang` (`VORGANGSID`, `INHALT`) VALUES
(1, 'Exemplar ausgeliehen'),
(2, 'Exemplar zurückgegeben'),
(3, 'Exemplar hinzugefügt'),
(4, 'Exemplar entfernt'),
(5, 'Person hinzugefügt'),
(6, 'Person entfernt'),
(7, 'Person abgemahnt'),
(8, 'Benutzer hinzugefügt'),
(9, 'Benutzer gelöscht'),
(10, 'Exemplar bearbeitet'),
(11, 'Ausleihe verlängert');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `zustand`
--

CREATE TABLE IF NOT EXISTS `zustand` (
  `ZUSTANDSID` int(11) NOT NULL auto_increment,
  `INHALT` char(32) NOT NULL,
  `bild` blob,
  PRIMARY KEY  (`ZUSTANDSID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Daten für Tabelle `zustand`
--

INSERT INTO `zustand` (`ZUSTANDSID`, `INHALT`, `bild`) VALUES
(1, 'Neuwertig', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000045749444154484bcd957d4cd4751cc7adc5fd7ef7400736909134d7a416cce8613d4c39401e05e4209e9f2c418c902090074d49a768c6d65c35b74004098fe310eec4432284d220404122d0cd885c6b6bfd97fff48f6dad77efef71771e4f69cd3fbaedb3bbfbddf7fb7a7f7eafcff7ee56adfabf3cc23a246f5610cb9fa57e207d111497dde767a8187ee9f6e189081c9fd6a36e2a16fbc742507ce9d999388b472dd7f8fdeb30d165fe80ffc8c99b59b0fcbc13865b71689adb84fad92034ccbe88c61f4260984b81e9c722d48c86fd9162f539ca3d6ef715c48591355774b73b7ecac289efd7a3ee86bbad3e60bd7f5d8323331a1c9ed2e0e0a4060726b5f868e655d4cfe420c5ea3bc8bd9eff18c205ba835743ee34cf6d74821df0a384d74e6b7088f00384efbfa6c19eab2a548ea95035ba1a1f4f2522d5ba76940c79d9107ea0dd33f2caaf9fce062e845f77872bfc3dc2f74da8514d7805e1ef7ca342f190124597d5a81d0b4772b7ef27cb06a45df0f9f0c4cd0d0be0c708b729f98e4abed5a086f077c7d5a8baa2c2ee51154a8755d8f5b5126f7ea5c48e4125b65f54a164f0b93fd96ce082105ed0548eaeffdde15b3c1f73f876c0a964af1d5e3e42900b3c9ff0d7fb6564f7c9c8ebf34182c5ab7171406af5b8376ae8f7103dd7b2eb238b7cefb5fb16f0b7879578ebb2123bd979de8012db08cffa5cc66b16195b0c0ac49a3c7e63d30f3b4362cceae3d5d778eb745b31ae42391594d16ff9989a2ad410d0b2c55d0b709f12e95619496619716d12a25b15886c5120caa001039e710624f5a8cd9502ce2ecb092e25ac980a8a1c7e097be30b2572d965568f8cb46e19c966098967256c6d97106b988747101ed6ac40e8694904c43a03127be49edd848bae4bec7087827c3b3ca7574626bb4d3b47155d12f41d12e28d12954888fa8cf0d384372910d2a880ee145f774849ce8084f32a43194f45098fdcae21150ae9b7e04bfabdc8e15143ce051919e765a4d27112e10984c7111e73661e1e4e7828e1ba930a6c6a7083aec97607a1ce80c84ef53ea1c406bf44b83872fdc2314f861d9e22e09d849b08a7ef9833f3be370b25ecd801df58ef869016f92f06ac7106f0cdcb3b063def9e67c21dbed36dbee579df84c7da87297c0bb850122c3a2758c0831b2444b4b94f2f3ea60f65f67adf2818d4cc0fd3c5b718a69ef0780ed3e65b0cd3c5777083c20676544c8b97d053bee4dbcc8be98503ebe01866ea0ac314bec53075a273fa768547353f8668a3e72f2bfe5fc45b3cba0bfb9fe44951ddf56d1b267d7398cbf9760444377b21a1fd71e17eeb8abfa8fcf0d178b3e76441efd348eed43a7d2f19a68b12e15cdffa04f4ed7e086d5354ddf33f41dcde962eedb93c6b00722dfe48347a21bc595e32ccf0535a24b4fa21d314c8e1fbdee1bedc7bc21d0bc4ef082b5bdfb5e65646973fb69b5fc0b6b341c8680f4056c706be7e1e19a60076bd161126f72eae7deabee1ae0bb9f11156589849aa8b306aacd1edab27228ddaa1cd46a589d74b59ebfe13f8416efa1b603b0ed71ffa90ed0000000049454e44ae426082),
(2, 'Fast neuwertig', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000045749444154484bcd957d4cd4751cc7adc5fd7ef7400736909134d7a416cce8613d4c39401e05e4209e9f2c418c902090074d49a768c6d65c35b74004098fe310eec4432284d220404122d0cd885c6b6bfd97fff48f6dad77efef71771e4f69cd3fbaedb3bbfbddf7fb7a7f7eafcff7ee56adfabf3cc23a246f5610cb9fa57e207d111497dde767a8187ee9f6e189081c9fd6a36e2a16fbc742507ce9d999388b472dd7f8fdeb30d165fe80ffc8c99b59b0fcbc13865b71689adb84fad92034ccbe88c61f4260984b81e9c722d48c86fd9162f539ca3d6ef715c48591355774b73b7ecac289efd7a3ee86bbad3e60bd7f5d8323331a1c9ed2e0e0a4060726b5f868e655d4cfe420c5ea3bc8bd9eff18c205ba835743ee34cf6d74821df0a384d74e6b7088f00384efbfa6c19eab2a548ea95035ba1a1f4f2522d5ba76940c79d9107ea0dd33f2caaf9fce062e845f77872bfc3dc2f74da8514d7805e1ef7ca342f190124597d5a81d0b4772b7ef27cb06a45df0f9f0c4cd0d0be0c708b729f98e4abed5a086f077c7d5a8baa2c2ee51154a8755d8f5b5126f7ea5c48e4125b65f54a164f0b93fd96ce082105ed0548eaeffdde15b3c1f73f876c0a964af1d5e3e42900b3c9ff0d7fb6564f7c9c8ebf34182c5ab7171406af5b8376ae8f7103dd7b2eb238b7cefb5fb16f0b7879578ebb2123bd979de8012db08cffa5cc66b16195b0c0ac49a3c7e63d30f3b4362cceae3d5d778eb745b31ae42391594d16ff9989a2ad410d0b2c55d0b709f12e95619496619716d12a25b15886c5120caa001039e710624f5a8cd9502ce2ecb092e25ac980a8a1c7e097be30b2572d965568f8cb46e19c966098967256c6d97106b988747101ed6ac40e8694904c43a03127be49edd848bae4bec7087827c3b3ca7574626bb4d3b47155d12f41d12e28d12954888fa8cf0d384372910d2a880ee145f774849ce8084f32a43194f45098fdcae21150ae9b7e04bfabdc8e15143ce051919e765a4d27112e10984c7111e73661e1e4e7828e1ba930a6c6a7083aec97607a1ce80c84ef53ea1c406bf44b83872fdc2314f861d9e22e09d849b08a7ef9833f3be370b25ecd801df58ef869016f92f06ac7106f0cdcb3b063def9e67c21dbed36dbee579df84c7da87297c0bb850122c3a2758c0831b2444b4b94f2f3ea60f65f67adf2818d4cc0fd3c5b718a69ef0780ed3e65b0cd3c5777083c20676544c8b97d053bee4dbcc8be98503ebe01866ea0ac314bec53075a273fa768547353f8668a3e72f2bfe5fc45b3cba0bfb9fe44951ddf56d1b267d7398cbf9760444377b21a1fd71e17eeb8abfa8fcf0d178b3e76441efd348eed43a7d2f19a68b12e15cdffa04f4ed7e086d5354ddf33f41dcde962eedb93c6b00722dfe48347a21bc595e32ccf0535a24b4fa21d314c8e1fbdee1bedc7bc21d0bc4ef082b5bdfb5e65646973fb69b5fc0b6b341c8680f4056c706be7e1e19a60076bd161126f72eae7deabee1ae0bb9f11156589849aa8b306aacd1edab27228ddaa1cd46a589d74b59ebfe13f8416efa1b603b0ed71ffa90ed0000000049454e44ae426082),
(3, 'leicht verschmutzt', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000046849444154484bcd956b50945518c7ada99966329d96658105845d16909506875c6e2db785d0051412512e22106686712bca5b859769ca3231db49c04ac6266874ac0045577705563040ee17c1706b12a7a6cb973ee4877ace4cfff3beecba4b90d6f8a19d796667df3de7f7fcdfdf73f6dd050bfe2faf378316c950212815ead1fb920b20fd717de089b35be27fb56c4f67fd6f6d62dd7bb298a92c997d991739541de6be176bbcff75339eb2616dc8e5890f8ad94fa776b11fea8bd8adda4c366d4861370d6bd8f4d12c76abbe984d7fb69b5daa587dbb265eb91f7b1ebea7465898682e4ffee5c7863276b33a9ebedb1f2cd4b7fb9691750fea0d354dbda6a66f762ea5eb3bd4643d98c6260ddb586dbcf202f63efe8f4db040db56997a9ba7b5819de0af03be3b08e0a534f94a204dbc1440e3a5fe3456be8c26de2b60753a5527188fccd9045f2c3e5f9c383d7d64a53db500df2b26bfc1e1bb00df0e7865005dab00b85445a3c57e34bc4549839bfd68a82a83d5c6290fcfd9a04ea778d77ac801be6f065e05385722c003efc04b5434f202a0cf2969e05905f56ff2a1be8dbe642c8afe0361d54e4d7061e1c5ad9adfeef80e262b4f5ea516e13b8368f2552879194aca90fc45c0b7cec00b15d407f8d59c25d4bdde9b7af2d464885a5237bb41c640e9133485dbbf01c77c9056c137e08ebe011fdd06f8f37e50a2a4fe02c0f37ca8371bf04c2fb2ac96d3c5a7dda85eebf933423f686f7228547af07a45004d96fbd30486368e84e300f1a46350c1df3978d8961a4a38b807e0ae0c2fea00d894e44ec604199d8b97d1e75a774283207b838f6264a726916ea204700e86db110c6e68b382060a7d0505bdb94899e54d5790f4f2339ed4b1464e6d291e645ee52ea416e071aed41a2da593112ebcc12a7b838fa3a54dd79094c34791929f8aa122117e952785dfaf377853d73a67b869a53b5d00fcbc4e849f05fccc53681026e10dd2ec0d6aa25c4f8cd9e038158380f71738c33ba1c292ee49edd07129d9830478a2086f8d055c2ba59628176a8e74a1468d700731f606ef8448760c023ccce1fcc8e5fb52ef461fea86e32b3819023c4d4eeda950a287922428e170f86e8d7180434d53b8843e0995fcc91f8ef606f8a03167ab44dff9cebe3bd7c237e0826f1b5cf0cde150624b3e036f8e9452cd0ad9e0ec63fa40835e39d297af9cdf3786c97d1b67f96e8192e60889905c289d2fd753feb75f332e665a0a963b0f730edfe7b86f6198a2ef260778abce878e45c8bf9ff7ffc210e1f1455761288ea197384cbdc330b9ef59c3b4a746f2d6040535ea54dc7dcabc4f547cf9d88791f25e4bbe86b5a7f98ac39cf9f1f061cef6cd1b70e7c614359d4e0aa4eae0c59577fd4fe0b77744e376da941bce2c394f3253aa0ac965c2f9167d8b27e54cac27199383c89419c63e8df3fb1dfb72ef0ab72de0cf1154f6f158c5544b7a08ebc8d3b2b69c28665e1fc6cc1b22585bae9619d7695863823f1d5e2e3d89b501f70c775c888d0fa1620fa817bd6d0875fdaa365cde7374855bdbfb2192065c2f41f9fc27f0fddcf4176c2327588b431e410000000049454e44ae426082),
(4, 'leicht beschädigt', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000046849444154484bcd956b50945518c7ada99966329d96658105845d16909506875c6e2db785d0051412512e22106686712bca5b859769ca3231db49c04ac6266874ac0045577705563040ee17c1706b12a7a6cb973ee4877ace4cfff3beecba4b90d6f8a19d796667df3de7f7fcdfdf73f6dd050bfe2faf378316c950212815ead1fb920b20fd717de089b35be27fb56c4f67fd6f6d62dd7bb298a92c997d991739541de6be176bbcff75339eb2616dc8e5890f8ad94fa776b11fea8bd8adda4c366d4861370d6bd8f4d12c76abbe984d7fb69b5daa587dbb265eb91f7b1ebea7465898682e4ffee5c7863276b33a9ebedb1f2cd4b7fb9691750fea0d354dbda6a66f762ea5eb3bd4643d98c6260ddb586dbcf202f63efe8f4db040db56997a9ba7b5819de0af03be3b08e0a534f94a204dbc1440e3a5fe3456be8c26de2b60753a5527188fccd9045f2c3e5f9c383d7d64a53db500df2b26bfc1e1bb00df0e7865005dab00b85445a3c57e34bc4549839bfd68a82a83d5c6290fcfd9a04ea778d77ac801be6f065e05385722c003efc04b5434f202a0cf2969e05905f56ff2a1be8dbe642c8afe0361d54e4d7061e1c5ad9adfeef80e262b4f5ea516e13b8368f2552879194aca90fc45c0b7cec00b15d407f8d59c25d4bdde9b7af2d464885a5237bb41c640e9133485dbbf01c77c9056c137e08ebe011fdd06f8f37e50a2a4fe02c0f37ca8371bf04c2fb2ac96d3c5a7dda85eebf933423f686f7228547af07a45004d96fbd30486368e84e300f1a46350c1df3978d8961a4a38b807e0ae0c2fea00d894e44ec604199d8b97d1e75a774283207b838f6264a726916ea204700e86db110c6e68b382060a7d0505bdb94899e54d5790f4f2339ed4b1464e6d291e645ee52ea416e071aed41a2da593112ebcc12a7b838fa3a54dd79094c34791929f8aa122117e952785dfaf377853d73a67b869a53b5d00fcbc4e849f05fccc53681026e10dd2ec0d6aa25c4f8cd9e038158380f71738c33ba1c292ee49edd07129d9830478a2086f8d055c2ba59628176a8e74a1468d700731f606ef8448760c023ccce1fcc8e5fb52ef461fea86e32b3819023c4d4eeda950a287922428e170f86e8d7180434d53b8843e0995fcc91f8ef606f8a03167ab44dff9cebe3bd7c237e0826f1b5cf0cde150624b3e036f8e9452cd0ad9e0ec63fa40835e39d297af9cdf3786c97d1b67f96e8192e60889905c289d2fd753feb75f332e665a0a963b0f730edfe7b86f6198a2ef260778abce878e45c8bf9ff7ffc210e1f1455761288ea197384cbdc330b9ef59c3b4a746f2d6040535ea54dc7dcabc4f547cf9d88791f25e4bbe86b5a7f98ac39cf9f1f061cef6cd1b70e7c614359d4e0aa4eae0c59577fd4fe0b77744e376da941bce2c394f3253aa0ac965c2f9167d8b27e54cac27199383c89419c63e8df3fb1dfb72ef0ab72de0cf1154f6f158c5544b7a08ebc8d3b2b69c28665e1fc6cc1b22585bae9619d7695863823f1d5e2e3d89b501f70c775c888d0fa1620fa817bd6d0875fdaa365cde7374855bdbfb2192065c2f41f9fc27f0fddcf4176c2327588b431e410000000049454e44ae426082),
(5, 'stark verschmutzt', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000041949444154484bcd955b4c9b651cc6a791f66bbf62610646701484b6b49c4acb380c46396dea88712633ba03f110a3719a2c31d12cd98d17c6a889f1c22bd9189b0cda7228b032c690ea948e96c36605974cc4c59818efdc8d3733313e3eefd7efaba53037cd2e24f95ff0f57d7fcfd3dffbb6ddb2e5fff23768d1e7725c1c1b47be27bd08ea9caa2fe88fecabbdb9f45c07965f7f12f157f62276c08b4b8f57ad8c3ab2dee19a827f1d265ace786d73d78f1dc44fefbf8c1b6f7662ed4813565f7061f5a51a7cff9a176bc7f7e387f78e207aa8f5f7903bef5deec9b8ab202edc3d7fa0f9e68f6f1fc477cf5a716d776672beed3061a5dd84789b09575b396d66acbcd8809563871172e787b937fb1f43b8a079e1b0f7d6daab8debc02244c09735788b0957bc262c3419116b3422dab215f1a3fb10aad91e2543da34842f98e7f6d7ffb2da559ed65a85b3755cb4267ca9594ec0771a71b9c188d95a03beac95117bbe1de3eefc8f370d38efcefbf07a57e506b850f20de15fabf0c55d32e6098f121ea937e22bc2bfa83120ec31e0338f11e1ceea3f58b67c5d081f98a28f597fdbccb706174a143895cc69f01d2adc6dc0b44bc25425a7210fa3153927d3039e5e6ccb459c9065b615ad93bed95cf1bd2be17b8e4a22f55422e06c3d23e055122e544818754ae8b7ea107064fdcad2f727438256f9a32b4d32961a652c1232cf863182623b65aa90156802ac2a215c80a7aa0c08111c744818b0e9d157a2c399621dfa6d2630c0990c9870c841015f50c1730445ea08531508d8c56a032eb0e90481e3e5843af51872e8e1b7ebd95a853fa2436f910ea78bf42260efdf017669221d9eaae0a2cb8049c245dbb1320923840f96eae153e19fb2f569c24f117eb250871e8b4e043c950c386737f647a9e0329bcfd61a15bf9f8b5bc1d653849fe7e19d138e059cad1538959c65f354f809c2bb2d193855a8bc839664c070b17c3c42b0805f52afdcb4029712702a11f061c2036c2d7c9f557df7b2790fc127d85ac03f29c8c09942e94f066c4b06f09fba705d76e23e8b5ba1f9263ce15b527c2bf034df4289800bb0986eb61fb0662ea75fd3fb263db9d7c23526acf3ad1d2695a41e66aaefee14b8d2be3c47e87963c3a7990f9f996929c2245b6f384c2a113725fd3035255afb5ee743f039b27fbeedefc5a8336b7cbab5186315c6846fed30e95bc015dfbc29a9be937036f7573f2cdc3f71db6f54bef860d0997d75b2bd14c395e6751f1e71bfb5c3d4a09af3be1d16f83d0518b0e8debae36f82787b23a5e6b1507b1946bd36f85c39e82d9694fb9d7a983d7633fa6a0a10682d47c0957f8bfbbaee08d71688ef11cea191aa6d37469a6c083eeac150870bfe96320cb65562688f1b016f19fceeed0894648e70adfdaee1a90bb9f1014e6bc0a2ffc057620af94bb72ef96ce6595f9121c0e7473945ff097c2f37fd052389cda7baf0d6b10000000049454e44ae426082),
(6, 'stark beschädigt', 0x89504e470d0a1a0a0000000d4948445200000018000000180806000000e0773df80000000467414d410000b18e7cfb5193000000206348524d0000870f00008c0f0000fd520000814000007d790000e98b00003ce5000019cc733c857700000a396943435050686f746f73686f70204943432070726f66696c65000048c79d96775454d71687cfbd777aa1cd30d2197a932e3080f42e201d045118660618ca00c30c4d6c88a840441111014590a08001a3a148ac88622128a8600f48105062308aa8a86446d64a7c7979efe5e5f7c7bddfda67ef73f7d97b9fb52e00244f1f2e2f059602209927e0077a38d3578547d0b1fd0006788001a6003059e9a9be41eec140242f37177abac809fc8bde0c0148fcbe65e8e94fa783ff4fd2ac54be0000c85fc4e66c4e3a4bc4f9224eca14a48aed3322a6c6248a194689992f4a50c472628e5be4a59f7d16d951ccec641e5bc4e29c53d9c96c31f788787b86902362c447c405195c4ea6886f8b58334998cc15f15b716c3287990e008a24b60b38ac78119b8898c40f0e7411f1720070a4b82f38e60b1670b204e243b9a4a466f3b971f102ba2e4b8f6e6a6dcda07b723293380281a13f9395c8e4b3e92e29c9a94c5e36008b67fe2c19716de9a2225b9a5a5b5a1a9a19997e51a8ffbaf83725eeed22bd0af8dc3388d6f787edaffc52ea0060cc8a6ab3eb0f5bcc7e003ab6022077ff0f9be6210024457d6bbff1c57968e279891708526d8c8d3333338db81c9691b8a0bfeb7f3afc0d7df13d23f176bf9787eeca89650a93047471dd58294929423e3d3d95c9e2d00dff3cc4ff38f0aff3581ac889e5f0393c5144a868cab8bc3851bb796cae809bc2a37379ffa989ff30ec4f5a9c6b9128f59f0035ca0848dda002e4e73e80a21001127950dcf5dffbe6830f05e29b17a63ab138f79f05fdfbae7089f891ce8dfb1ce712184c6709f9198b6be26b09d08000240115c80315a001748121300356c016380237b002f88160100ed602168807c9800f32412ed80c0a4011d805f6824a5003ea41236801274007380d2e80cbe03ab809ee800760048c83e76006bc01f310046121324481e42155480b3280cc2006640fb9413e5020140e454371100f1242b9d016a8082a852aa15aa811fa163a055d80ae4203d03d68149a827e85dec3084c82a9b032ac0d1bc30cd809f68683e135701c9c06e7c0f9f04eb802ae838fc1edf005f83a7c071e819fc3b3084088080d51430c1106e282f82111482cc24736208548395287b4205d482f720b1941a69177280c8a82a2a30c51b6284f54088a854a436d4015a32a514751eda81ed42dd4286a06f5094d462ba10dd036682ff42a741c3a135d802e4737a0dbd097d077d0e3e837180c8686d1c158613c31e19804cc3a4c31e600a615731e338019c3cc62b15879ac01d60eeb87656205d802ec7eec31ec39ec20761cfb1647c4a9e2cc70eeb8081c0f97872bc735e1cee2067113b879bc145e0b6f83f7c3b3f1d9f8127c3dbe0b7f033f8e9f274813740876846042026133a182d042b844784878452412d589d6c4002297b88958413c4ebc421c25be23c990f4492ea4489290b4937484749e748ff48a4c266b931dc91164017927b9917c91fc98fc5682226124e125c196d8285125d12e3128f142122fa925e924b9563247b25cf2a4e40dc96929bc94b6948b14536a835495d429a961a959698ab4a9b49f74b274b17493f455e94919ac8cb68c9b0c5b265fe6b0cc4599310a42d1a0b85058942d947aca25ca381543d5a17a5113a845d46fa8fdd4195919d965b2a1b259b255b267644768084d9be6454ba295d04ed08668ef97282f715ac259b26349cb92c12573728a728e721cb942b956b93b72efe5e9f26ef289f2bbe53be41f29a014f415021432150e2a5c529856a42ada2ab2140b154f28de578295f4950295d6291d56ea539a555651f6504e55deaf7c51795a85a6e2a892a052a67256654a95a26aafca552d533da7fa8c2e4b77a227d12be83df4193525354f35a15aad5abfdabcba8e7a887a9e7aabfa230d8206432356a34ca35b63465355d3573357b359f3be165e8ba115afb54fab576b4e5b473b4c7b9b7687f6a48e9c8e974e8e4eb3ce435db2ae836e9a6e9dee6d3d8c1e432f51ef80de4d7d58df423f5ebf4aff86016c6069c035386030b014bdd47a296f69ddd2614392a193618661b3e1a811cdc8c728cfa8c3e885b1a67184f16ee35ee34f2616264926f5260f4c654c5798e6997699fe6aa66fc632ab32bb6d4e367737df68de69fe7299c132ceb283cbee5a502c7c2db659745b7cb4b4b2e45bb6584e59695a455b555b0d33a80c7f4631e38a35dadad97aa3f569eb77369636029b1336bfd81ada26da36d94e2ed759ce595ebf7ccc4edd8e69576b37624fb78fb63f643fe2a0e6c074a87378e2a8e1c8766c709c70d2734a703ae6f4c2d9c499efdce63ce762e3b2dee5bc2be2eae15ae8daef26e316e256e9f6d85ddd3dcebdd97dc6c3c2639dc7794fb4a7b7e76ecf612f652f9657a3d7cc0aab15eb57f47893bc83bc2bbd9ff8e8fbf07dba7c61df15be7b7c1faed45ac95bd9e107fcbcfcf6f83df2d7f14ff3ff3e0013e01f5015f034d0343037b03788121415d414f426d839b824f841886e8830a43b54323432b431742ecc35ac346c6495f1aaf5abae872b8473c33b23b011a1110d11b3abdd56ef5d3d1e6911591039b446674dd69aab6b15d626ad3d132519c58c3a198d8e0e8b6e8afec0f463d6316763bc62aa6366582eac7dace76c4776197b8a63c729e54cc4dac596c64ec6d9c5ed899b8a77882f8f9fe6ba702bb92f133c136a12e612fd128f242e248525b526e392a3934ff1647889bc9e149594ac94815483d482d491349bb4bd69337c6f7e433a94be26bd534015fd4cf50975855b85a319f61955196f3343334f664967f1b2fab2f5b377644fe4b8e77cbd0eb58eb5ae3b572d7773eee87aa7f5b51ba00d311bba376a6cccdf38bec963d3d1cd84cd899b7fc833c92bcd7bbd256c4b57be72fea6fcb1ad1e5b9b0b240af805c3db6cb7d56c476de76eefdf61be63ff8e4f85ecc26b452645e5451f8a59c5d7be32fdaae2ab859db13bfb4b2c4b0eeec2ece2ed1adaedb0fb68a974694ee9d81edf3ded65f4b2c2b2d77ba3f65e2d5f565eb38fb04fb86fa4c2a7a273bfe6fe5dfb3f54c657dea972ae6aad56aade513d77807d60f0a0e3c1961ae59aa29af787b887eed67ad4b6d769d7951fc61cce38fcb43eb4bef76bc6d78d0d0a0d450d1f8ff08e8c1c0d3cdad368d5d8d8a4d454d20c370b9ba78e451ebbf98deb379d2d862db5adb4d6a2e3e0b8f0f8b36fa3bf1d3ae17da2fb24e364cb775adf55b751da0adba1f6ecf6998ef88e91cef0ce81532b4e7577d976b57d6ff4fd91d36aa7abcec89e29394b389b7f76e15cceb9d9f3a9e7a72fc45d18eb8eea7e7071d5c5db3d013dfd97bc2f5db9ec7ef962af53efb92b76574e5fb5b97aea1ae35ac775cbebed7d167d6d3f58fcd0d66fd9df7ec3ea46e74deb9b5d03cb07ce0e3a0c5eb8e57aebf26dafdbd7efacbc333014327477387278e42efbeee4bda47b2fef67dc9f7fb0e921fa61e123a947e58f951ed7fda8f763eb88e5c89951d7d1be27414f1e8cb1c69eff94fed387f1fca7e4a7e513aa138d936693a7a7dca76e3e5bfd6cfc79eaf3f9e9829fa57fae7ea1fbe2bb5f1c7fe99b593533fe92ff72e1d7e257f2af8ebc5ef6ba7bd67ff6f19be437f373856fe5df1e7dc778d7fb3eecfdc47ce607ec878a8f7a1fbb3e797f7ab890bcb0f01bf784f3fbe2e61dc2000000097048597300000b1200000b1201d2dd7efc0000001874455874536f667477617265005061696e742e4e45542076332e3336a9e7e2250000041949444154484bcd955b4c9b651cc6a791f66bbf62610646701484b6b49c4acb380c46396dea88712633ba03f110a3719a2c31d12cd98d17c6a889f1c22bd9189b0cda7228b032c690ea948e96c36605974cc4c59818efdc8d3733313e3eefd7efaba53037cd2e24f95ff0f57d7fcfd3dffbb6ddb2e5fff23768d1e7725c1c1b47be27bd08ea9caa2fe88fecabbdb9f45c07965f7f12f157f62276c08b4b8f57ad8c3ab2dee19a827f1d265ace786d73d78f1dc44fefbf8c1b6f7662ed4813565f7061f5a51a7cff9a176bc7f7e387f78e207aa8f5f7903bef5deec9b8ab202edc3d7fa0f9e68f6f1fc477cf5a716d776672beed3061a5dd84789b09575b396d66acbcd8809563871172e787b937fb1f43b8a079e1b0f7d6daab8debc02244c09735788b0957bc262c3419116b3422dab215f1a3fb10aad91e2543da34842f98e7f6d7ffb2da559ed65a85b3755cb4267ca9594ec0771a71b9c188d95a03beac95117bbe1de3eefc8f370d38efcefbf07a57e506b850f20de15fabf0c55d32e6098f121ea937e22bc2bfa83120ec31e0338f11e1ceea3f58b67c5d081f98a28f597fdbccb706174a143895cc69f01d2adc6dc0b44bc25425a7210fa3153927d3039e5e6ccb459c9065b615ad93bed95cf1bd2be17b8e4a22f55422e06c3d23e055122e544818754ae8b7ea107064fdcad2f727438256f9a32b4d32961a652c1232cf863182623b65aa90156802ac2a215c80a7aa0c08111c744818b0e9d157a2c399621dfa6d2630c0990c9870c841015f50c1730445ea08531508d8c56a032eb0e90481e3e5843af51872e8e1b7ebd95a853fa2436f910ea78bf42260efdf017669221d9eaae0a2cb8049c245dbb1320923840f96eae153e19fb2f569c24f117eb250871e8b4e043c950c386737f647a9e0329bcfd61a15bf9f8b5bc1d653849fe7e19d138e059cad1538959c65f354f809c2bb2d193855a8bc839664c070b17c3c42b0805f52afdcb4029712702a11f061c2036c2d7c9f557df7b2790fc127d85ac03f29c8c09942e94f066c4b06f09fba705d76e23e8b5ba1f9263ce15b527c2bf034df4289800bb0986eb61fb0662ea75fd3fb263db9d7c23526acf3ad1d2695a41e66aaefee14b8d2be3c47e87963c3a7990f9f996929c2245b6f384c2a113725fd3035255afb5ee743f039b27fbeedefc5a8336b7cbab5186315c6846fed30e95bc015dfbc29a9be937036f7573f2cdc3f71db6f54bef860d0997d75b2bd14c395e6751f1e71bfb5c3d4a09af3be1d16f83d0518b0e8debae36f82787b23a5e6b1507b1946bd36f85c39e82d9694fb9d7a983d7633fa6a0a10682d47c0957f8bfbbaee08d71688ef11cea191aa6d37469a6c083eeac150870bfe96320cb65562688f1b016f19fceeed0894648e70adfdaee1a90bb9f1014e6bc0a2ffc057620af94bb72ef96ce6595f9121c0e7473945ff097c2f37fd052389cda7baf0d6b10000000049454e44ae426082);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `beinhaltet`
--
ALTER TABLE `beinhaltet`
  ADD CONSTRAINT `FK_BEINHALTET` FOREIGN KEY (`TAGID`) REFERENCES `schlagworte` (`TAGID`),
  ADD CONSTRAINT `FK_BEINHALTET2` FOREIGN KEY (`MEDIENID`) REFERENCES `medium` (`MEDIENID`);

--
-- Constraints der Tabelle `exemplar`
--
ALTER TABLE `exemplar`
  ADD CONSTRAINT `FK_GEHOERT_ZU` FOREIGN KEY (`MEDIENID`) REFERENCES `medium` (`MEDIENID`),
  ADD CONSTRAINT `FK_HAT` FOREIGN KEY (`ZUSTANDSID`) REFERENCES `zustand` (`ZUSTANDSID`),
  ADD CONSTRAINT `FK_LEIHT_AUS` FOREIGN KEY (`AUSLEIHERID`) REFERENCES `ausleiher` (`AUSLEIHERID`);

--
-- Constraints der Tabelle `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `FK_LOGGT` FOREIGN KEY (`EXEMPLARID`) REFERENCES `exemplar` (`EXEMPLARID`),
  ADD CONSTRAINT `FK_LOGGT2` FOREIGN KEY (`AUSLEIHERID`) REFERENCES `ausleiher` (`AUSLEIHERID`),
  ADD CONSTRAINT `FK_LOGGT3` FOREIGN KEY (`ANWENDERNAME`) REFERENCES `anwender` (`ANWENDERNAME`),
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`VORGANGSID`) REFERENCES `vorgang` (`VORGANGSID`);
