<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : HojaEstilos.xsl
    Created on : 11 de noviembre de 2015, 10:25
    Author     : XvazqDios
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:param name="nota10">10</xsl:param>
    <xsl:param name="nota9">9</xsl:param>
    <xsl:param name="nota8">8</xsl:param>
    <xsl:param name="nota7">7</xsl:param>
    <xsl:param name="nota6">6</xsl:param>
    <xsl:param name="nota5">5</xsl:param>
    <xsl:param name="nota4">4</xsl:param>
    <xsl:param name="nota3">3</xsl:param>
    <xsl:param name="nota2">2</xsl:param>
    <xsl:param name="nota1">1</xsl:param>
    <xsl:param name="nota0">0</xsl:param>
    
    <xsl:template match="/">
        <xsl:element name="Notas">
            <xsl:apply-templates select="/Alumnos"/>
        </xsl:element> 
    </xsl:template>
    
    <xsl:template match="Alumnos">
            <nota valor = "{$nota10}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota10">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota9}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota9">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota8}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota8">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota7}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota7">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota6}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota6">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota5}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota5">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota4}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota4">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota3}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota3">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota2}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota2">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota1}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota1">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
            <nota valor = "{$nota0}">
                <xsl:for-each select="Alumno">
                    <xsl:if test="nota = $nota0">
                        <xsl:element name="Alumno">
                            <xsl:value-of select="nome"/>
                        </xsl:element>
                    </xsl:if>
                </xsl:for-each>
            </nota> 
    </xsl:template>

</xsl:stylesheet>
