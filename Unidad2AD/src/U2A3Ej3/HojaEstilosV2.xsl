<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : HojaEstilosV2.xsl
    Created on : 17 de noviembre de 2015, 10:17
    Author     : usuario
    Description:
        Purpose of transformation follows.
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
    <xsl:key name="c_tipo" match="Alumnos/Alumno" use="nota"/> 
    
    <xsl:template match="/">
        <xsl:element name="Notas">
            <xsl:for-each select="Alumnos/Alumno[generate-id(.)=generate-id(key('c_tipo',nota))]">
                <xsl:sort select="nota" order="descending"/>
                <xsl:element name="Nota">
                    <xsl:attribute name="valor">
                        <xsl:value-of select="nota"/>
                    </xsl:attribute>
                    <xsl:for-each select="key('c_tipo',nota)">
                        <!-- Para mostrarlos ordenados por el nombre <xsl:sort select="nome"/> -->
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each> 
        </xsl:element> 
    </xsl:template>
    
</xsl:stylesheet>