package com.github.jk1.license.importer

import spock.lang.Specification

class XmlReportImporterSpec extends Specification {

    def externalReport = new File(getClass().getResource('/dependencies.xml').toURI())
    def namespacedReport = new File(getClass().getResource('/external_dtd.xml').toURI())

    def "Importer should be able to parse xml input"() {
        def importer = new XmlReportImporter('Importer', externalReport)

        expect:
        !importer.doImport().isEmpty()
    }

    def "Importer should be able to handle lazy closures"() {
        def importer = new XmlReportImporter('Importer', { externalReport })

        expect:
        !importer.doImport().isEmpty()
    }

    def "Xml importer should ignore external XML schemas"() {
        def importer = new XmlReportImporter('Importer', namespacedReport)

        expect:
        !importer.doImport().isEmpty()
    }
}
