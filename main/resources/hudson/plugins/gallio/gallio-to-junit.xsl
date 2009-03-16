<?xml version='1.0' ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:a="http://www.gallio.org/">
	<xsl:template match="/">
		<xsl:for-each select="a:report/a:testPackageRun">
			<testsuites>
				<xsl:for-each select="a:testStepRun/a:children/a:testStepRun/a:children/a:testStepRun/a:children/a:testStepRun">
					<testsuite skipped="0" failures="0" errors="0">
						<xsl:attribute name="time">
							<xsl:value-of select="a:result/@duration"/>
						</xsl:attribute>
						<xsl:attribute name="tests">
							<xsl:value-of select="count(a:children/a:testStepRun)"/>
						</xsl:attribute>
						<xsl:attribute name="errors">
							<xsl:value-of select="count(a:children/a:testStepRun/a:result/a:outcome[@status = 'failed' and @category='error'])"/>
						</xsl:attribute>
						<xsl:attribute name="failures">
							<xsl:value-of select="count(a:children/a:testStepRun/a:result/a:outcome[@status = 'failed'])"/>
						</xsl:attribute>
						<xsl:attribute name="skipped">
							<xsl:value-of select="count(a:children/a:testStepRun/a:result/a:outcome[@status = 'skipped'])"/>
						</xsl:attribute>
						<xsl:attribute name="name">
							<xsl:value-of select="a:testStep/a:codeReference/@type"/>
						</xsl:attribute>
						<xsl:for-each select="a:children/a:testStepRun">
							<xsl:if test="a:result/a:outcome/@status != 'skipped'">
								<testcase>
									<xsl:attribute name="time">
										<xsl:value-of select="a:result/@duration"/>
									</xsl:attribute>
									<xsl:attribute name="name">
										<xsl:value-of select="a:testStep/@name"/>
									</xsl:attribute>
									<xsl:attribute name="classname">
										<xsl:value-of select="../../a:testStep/a:codeReference/@type"/>
									</xsl:attribute>
									<xsl:if test="a:result/a:outcome/@status = 'failed'">
										<failure>
											<xsl:attribute name="message">
												<!--for Gallio/Nunit-->
												<xsl:value-of select="a:testLog/a:streams/a:stream/a:body/a:contents/a:section/a:contents/a:text"/>
												<!--for Gallio/Mbunit-->
												<!--ExceptionMessage-->
												<xsl:for-each select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:marker">
														<xsl:if test="@class = 'ExceptionMessage'">
															<xsl:value-of select="a:contents/a:text"/>
														</xsl:if>
												</xsl:for-each>
												<!--Assertion Failure-->
												<xsl:value-of select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:section/@name"/>
												<xsl:for-each select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:section/a:contents/a:marker/a:contents/a:marker">
															<xsl:value-of select="a:contents/a:text"/>
												</xsl:for-each>
												<xsl:value-of select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:section/a:contents/a:marker/a:contents/a:text"/>
											</xsl:attribute>
											<!--for Gallio/Nunit-->
											<xsl:value-of select="a:testLog/a:streams/a:stream/a:body/a:contents/a:section/a:contents/a:marker/a:contents/a:text"/>
											<!--for Gallio/Mbunit-->
											<xsl:for-each select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:marker">
													<xsl:if test="@class = 'StackTrace'">
														<xsl:value-of select="a:contents/a:text"/>
													</xsl:if>
											</xsl:for-each>
											<!--<xsl:value-of select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:section/a:contents/a:marker/a:contents/a:text"/>-->
											<xsl:for-each select="a:testLog/a:streams/a:stream/a:body/a:contents/a:marker/a:contents/a:section/a:contents/a:marker">
													<xsl:if test="@class = 'StackTrace'">
														<xsl:value-of select="a:contents/a:text"/>
													</xsl:if>
											</xsl:for-each>
										</failure>
									</xsl:if>
								</testcase>
							</xsl:if>
						</xsl:for-each>
					</testsuite>
				</xsl:for-each>
			</testsuites>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2008. Progress Software Corporation. All rights reserved.

<metaInformation>
	<scenarios>
		<scenario default="yes" name="MbUnit_to_JUnit" userelativepaths="yes" externalpreview="no" url="..\..\..\..\..\..\..\..\..\..\huson_workspace\jobs\TestMbunit_Gallio\workspace\gallioResult.xml" htmlbaseurl=""
		          outputurl="huson_workspace\jobs\TestNunit_Gallio\workspace\nunitResult_converted.xml" processortype="internal" useresolver="yes" profilemode="0" profiledepth="" profilelength="" urlprofilexml="" commandline="" additionalpath=""
		          additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator="">
			<advancedProp name="sInitialMode" value=""/>
			<advancedProp name="bXsltOneIsOkay" value="true"/>
			<advancedProp name="bSchemaAware" value="true"/>
			<advancedProp name="bXml11" value="false"/>
			<advancedProp name="iValidation" value="0"/>
			<advancedProp name="bExtensions" value="true"/>
			<advancedProp name="iWhitespace" value="0"/>
			<advancedProp name="sInitialTemplate" value=""/>
			<advancedProp name="bTinyTree" value="true"/>
			<advancedProp name="bWarnings" value="true"/>
			<advancedProp name="bUseDTD" value="false"/>
			<advancedProp name="iErrorHandling" value="fatal"/>
		</scenario>
	</scenarios>
	<MapperMetaTag>
		<MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no">
			<SourceSchema srcSchemaPath="..\..\..\..\..\..\..\..\..\..\huson_workspace\jobs\TestMbunit_Gallio\workspace\gallioResult.xml" srcSchemaRoot="report" AssociatedInstance="" loaderFunction="document" loaderFunctionUsesURI="no"/>
		</MapperInfo>
		<MapperBlockPosition>
			<template match="/">
				<block path="xsl:for-each" x="296" y="18"/>
				<block path="xsl:for-each/testsuites/xsl:for-each" x="336" y="36"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:attribute[1]/xsl:value-of" x="336" y="72"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:attribute[2]/xsl:value-of" x="296" y="90"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:attribute[3]/xsl:value-of" x="336" y="108"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:attribute[4]/xsl:value-of" x="296" y="126"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:for-each" x="226" y="132"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:for-each/xsl:if/!=[0]" x="250" y="160"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:for-each/xsl:if" x="296" y="162"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:for-each/xsl:if/testcase/xsl:if/=[0]" x="250" y="232"/>
				<block path="xsl:for-each/testsuites/xsl:for-each/testsuite/xsl:for-each/xsl:if/testcase/xsl:if" x="296" y="234"/>
			</template>
		</MapperBlockPosition>
		<TemplateContext></TemplateContext>
		<MapperFilter side="source"></MapperFilter>
	</MapperMetaTag>
</metaInformation>
-->