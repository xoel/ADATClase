<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : EstiloActores.xsl.xsl
    Created on : 10 de noviembre de 2015, 10:21
    Author     : usuario
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->

    <xsl:template match="Actores">
        <head>
            <title>LISTADO DE ACTORES</title>
        </head>
        <body>
            <h1>Lista de Actores</h1>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Sexo</th>
                    <th>Data Nacemento</th>
                </tr>
                <xsl:for-each select="./Actor">
                    <tr>
                        <td><xsl:value-of select="nome"/></td>
                        <td><xsl:value-of select="sexo"/></td>
                        <td><xsl:value-of select="DataNacemento"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </xsl:template>
    
    
    
<!--    <xsl:template match="Actores">
        <tr><xsl:apply-templates/></tr>
   </xsl:template>
   
    <xsl:template match="Nome|Sexo|DataNacemento">
         <tr><xsl:apply-templates/></tr>
    </xsl:template>    -->
   
</xsl:stylesheet>
