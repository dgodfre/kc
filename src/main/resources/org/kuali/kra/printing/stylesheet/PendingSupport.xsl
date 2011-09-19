<?xml version="1.0" encoding="UTF-8"?>
<!--Designed and generated by Altova StyleVision Enterprise Edition 2008 rel. 2 - see http://www.altova.com/stylevision for more information.-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output version="1.0" method="xml" encoding="UTF-8" indent="no"/>
	<xsl:param name="SV_OutputFormat" select="'PDF'"/>
	<xsl:variable name="XML" select="/"/>
	<xsl:variable name="fo:layout-master-set">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="default-page" page-height="8.5in" page-width="11in" margin-left="0.8in" margin-right="0.8in">
				<fo:region-body margin-top="0.3in" margin-bottom="0.3in"/>
			</fo:simple-page-master>
		</fo:layout-master-set>
	</xsl:variable>
	<xsl:template match="/">
		<fo:root>
			<xsl:copy-of select="$fo:layout-master-set"/>
			<fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:for-each select="$XML">
							<fo:inline font-size="8" font-weight="bold" text-decoration="underline">
								<xsl:text>Pending Support for </xsl:text>
							</fo:inline>
							<xsl:for-each select="CurrentAndPendingSupport">
								<xsl:for-each select="PersonName">
									<xsl:variable name="value-of-template">
										<xsl:apply-templates/>
									</xsl:variable>
									<xsl:choose>
										<xsl:when test="contains(string($value-of-template),'&#x2029;')">
											<fo:block font-size="8" font-weight="bold" text-decoration="underline">
												<xsl:copy-of select="$value-of-template"/>
											</fo:block>
										</xsl:when>
										<xsl:otherwise>
											<fo:inline font-size="8" font-weight="bold" text-decoration="underline">
												<xsl:copy-of select="$value-of-template"/>
											</fo:inline>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:for-each>
							</xsl:for-each>
							<fo:block/>
							<fo:block>
								<fo:leader leader-pattern="space"/>
							</fo:block>
							<fo:inline-container>
								<fo:block>
									<xsl:text>&#x2029;</xsl:text>
								</fo:block>
							</fo:inline-container>
							<fo:block margin="0pt">
								<fo:block/>
							</fo:block>
							<fo:block/>
							<fo:inline-container>
								<fo:block>
									<xsl:text>&#x2029;</xsl:text>
								</fo:block>
							</fo:inline-container>
							<xsl:if test="CurrentAndPendingSupport/PendingSupport">
								<fo:table table-layout="auto" width="100%" border-spacing="0">
									<fo:table-header start-indent="0pt">
										<fo:table-row>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Proposal No</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Agency</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>PI</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Title</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Total Direct Cost</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Total F&amp;A Cost</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>																						
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Total Requested</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Eff. Date</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>End Date</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Effort %</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Academic Year</xsl:text>
													</fo:inline>
													<fo:block/>
													<fo:inline font-weight="bold">
														<xsl:text>Effort %</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>Summer Year Effort%</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline font-weight="bold">
														<xsl:text>CalendarYear </xsl:text>
													</fo:inline>
													<fo:block/>
													<fo:inline font-weight="bold">
														<xsl:text>Effort %</xsl:text>
													</fo:inline>
												</fo:block>
											</fo:table-cell>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName1">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName1">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											 </fo:table-cell>
											</xsl:if>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName2">
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName2">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											</fo:table-cell>
											</xsl:if>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName3">
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName3">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											 </fo:table-cell>
											</xsl:if>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName4">
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName4">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											 </fo:table-cell>
											</xsl:if>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName5">
											<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName5">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											 </fo:table-cell>
											</xsl:if>
											<xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName6">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName6">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											  </fo:table-cell>
											 </xsl:if>
											 <xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName7">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName7">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											  </fo:table-cell>
											 </xsl:if>
											 <xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName8">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName8">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											  </fo:table-cell>
											 </xsl:if>
											 <xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName9">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName9">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											  </fo:table-cell>
											 </xsl:if>
											 <xsl:if test="CurrentAndPendingSupport/PendingReportCEColumnNames/CEColumnName10">
											 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
												<fo:block>
													<fo:inline-container>
														<fo:block>
															<xsl:text>&#x2029;</xsl:text>
														</fo:block>
													</fo:inline-container>
													<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
														<fo:block>
															<xsl:for-each select="CurrentAndPendingSupport">
																<xsl:for-each select="PendingReportCEColumnNames">
																	<xsl:for-each select="CEColumnName10">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</xsl:for-each>
															</xsl:for-each>
														</fo:block>
													</fo:block>
												</fo:block>
											  </fo:table-cell>
											 </xsl:if>
										</fo:table-row>
									</fo:table-header>
									<fo:table-body start-indent="0pt">
										<xsl:for-each select="CurrentAndPendingSupport">
											<xsl:for-each select="PendingSupport">
												<fo:table-row>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="ProposalNumber">
																<xsl:variable name="value-of-template">
																	<xsl:apply-templates/>
																</xsl:variable>
																<xsl:choose>
																	<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																		<fo:block>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:block>
																	</xsl:when>
																	<xsl:otherwise>
																		<fo:inline>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:inline>
																	</xsl:otherwise>
																</xsl:choose>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="Agency">
																<xsl:variable name="value-of-template">
																	<xsl:apply-templates/>
																</xsl:variable>
																<xsl:choose>
																	<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																		<fo:block>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:block>
																	</xsl:when>
																	<xsl:otherwise>
																		<fo:inline>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:inline>
																	</xsl:otherwise>
																</xsl:choose>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="PI">
																<xsl:variable name="value-of-template">
																	<xsl:apply-templates/>
																</xsl:variable>
																<xsl:choose>
																	<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																		<fo:block>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:block>
																	</xsl:when>
																	<xsl:otherwise>
																		<fo:inline>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:inline>
																	</xsl:otherwise>
																</xsl:choose>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="Title">
																<xsl:variable name="value-of-template">
																	<xsl:apply-templates/>
																</xsl:variable>
																<xsl:choose>
																	<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																		<fo:block>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:block>
																	</xsl:when>
																	<xsl:otherwise>
																		<fo:inline>
																			<xsl:copy-of select="$value-of-template"/>
																		</fo:inline>
																	</xsl:otherwise>
																</xsl:choose>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="TotalDirectCost">
																<fo:inline>
																	<xsl:text>$</xsl:text>
																</fo:inline>
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="TotalIndirectCost">
																<fo:inline>
																	<xsl:text>$</xsl:text>
																</fo:inline>
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>																										
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="TotalRequested">
																<fo:inline>
																	<xsl:text>$</xsl:text>
																</fo:inline>
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="EffectiveDate">
																<fo:inline>
																	<xsl:value-of select="format-number(number(substring(string(string(.)), 6, 2)), '00')"/>
																	<xsl:text>/</xsl:text>
																	<xsl:value-of select="format-number(number(substring(string(string(.)), 9, 2)), '00')"/>
																	<xsl:text>/</xsl:text>
																	<xsl:value-of select="format-number(number(substring(string(string(string(.))), 1, 4)), '0000')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<xsl:for-each select="EndDate">
																<fo:inline>
																	<xsl:value-of select="format-number(number(substring(string(string(.)), 6, 2)), '00')"/>
																	<xsl:text>/</xsl:text>
																	<xsl:value-of select="format-number(number(substring(string(string(.)), 9, 2)), '00')"/>
																	<xsl:text>/</xsl:text>
																	<xsl:value-of select="format-number(number(substring(string(string(string(.))), 1, 4)), '0000')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="PercentageEffort">
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="AcademicYearEffort">
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="SummerYearEffort">
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="right" display-align="center">
														<fo:block>
															<xsl:for-each select="CalendarYearEffort">
																<fo:inline>
																	<xsl:value-of select="format-number(number(string(.)), '#,###,###,##0.00')"/>
																</fo:inline>
															</xsl:for-each>
														</fo:block>
													</fo:table-cell>
													<xsl:for-each select="PendingReportCEColomnValues">
													 <fo:table-cell border="solid 0.3pt black" font-size="6" padding="4pt" padding-right="4pt" text-align="left" display-align="center">
														<fo:block>
															<fo:inline-container>
																<fo:block>
																	<xsl:text>&#x2029;</xsl:text>
																</fo:block>
															</fo:inline-container>
															<fo:block white-space="pre" white-space-collapse="false" wrap-option="wrap" white-space-treatment="ignore-if-surrounding-linefeed" margin="0pt">
																<fo:block>
																	<xsl:for-each select="PendingReportCEColumnValue">
																		<xsl:variable name="value-of-template">
																			<xsl:apply-templates/>
																		</xsl:variable>
																		<xsl:choose>
																			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
																				<fo:block>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:block>
																			</xsl:when>
																			<xsl:otherwise>
																				<fo:inline>
																					<xsl:copy-of select="$value-of-template"/>
																				</fo:inline>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:for-each>
																</fo:block>
															</fo:block>
														</fo:block>
													 </fo:table-cell>
													</xsl:for-each>
												</fo:table-row>
											</xsl:for-each>
										</xsl:for-each>
									</fo:table-body>
								</fo:table>
							</xsl:if>
						</xsl:for-each>
					</fo:block>
					<fo:block id="SV_RefID_PageTotal"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="CurrentAndPendingSupport">
		<xsl:variable name="value-of-template">
			<xsl:apply-templates/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="contains(string($value-of-template),'&#x2029;')">
				<fo:block>
					<xsl:copy-of select="$value-of-template"/>
				</fo:block>
			</xsl:when>
			<xsl:otherwise>
				<fo:inline>
					<xsl:copy-of select="$value-of-template"/>
				</fo:inline>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="double-backslash">
		<xsl:param name="text"/>
		<xsl:param name="text-length"/>
		<xsl:variable name="text-after-bs" select="substring-after($text, '\')"/>
		<xsl:variable name="text-after-bs-length" select="string-length($text-after-bs)"/>
		<xsl:choose>
			<xsl:when test="$text-after-bs-length = 0">
				<xsl:choose>
					<xsl:when test="substring($text, $text-length) = '\'">
						<xsl:value-of select="concat(substring($text,1,$text-length - 1), '\\')"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$text"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat(substring($text,1,$text-length - $text-after-bs-length - 1), '\\')"/>
				<xsl:call-template name="double-backslash">
					<xsl:with-param name="text" select="$text-after-bs"/>
					<xsl:with-param name="text-length" select="$text-after-bs-length"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
