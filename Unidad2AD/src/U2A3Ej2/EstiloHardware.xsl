<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : EstiloHardware.xsl
    Created on : 11 de noviembre de 2015, 9:01
    Author     : usuario
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <xsl:element name="Hardware">
            <xsl:apply-templates select="//Maquina"/>
        </xsl:element>        
    </xsl:template>
    
    <xsl:template match="Maquina">   
        <xsl:element name="{name()}">
            <xsl:attribute name="Fbr">
                <xsl:value-of select="//Maquina/Info/Fabricante"/>
            </xsl:attribute>
            <xsl:if test="Notas">
                <xsl:comment>
                    <xsl:value-of select="Notas"/>
                </xsl:comment>
            </xsl:if>
            <xsl:element name="Nome">
                <xsl:value-of select="concat(@Nome,' (',Info/Tipo,')')"/>
            </xsl:element>
            <xsl:element name="Capacidade">
                <xsl:attribute name="tecnoloxia">
                    <xsl:value-of select="Info/Disco/@Tecnoloxía"/>
                </xsl:attribute>
                <xsl:value-of select="sum(Info/Disco/@Capacidade)"/>
            </xsl:element>
                
        </xsl:element>
    </xsl:template>
    

</xsl:stylesheet>
