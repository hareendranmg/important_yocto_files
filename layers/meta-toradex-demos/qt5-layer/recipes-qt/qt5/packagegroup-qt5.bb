DESCRIPTION = "QT5 base package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS:${PN} = " \
	qtbase \
	qtbase-tools \
	qtmultimedia \
	qtsvg \
	qtsensors \
	qtsystems \
	qtsystems-tools \
	qtscript \
	qtgraphicaleffects-qmlplugins \
	qtconnectivity-qmlplugins \
	qtlocation-plugins \
	qtlocation-qmlplugins \
	qtdeclarative \
	${QTWEBKIT} \
"

QTWEBKIT ??= "\
	qtwebkit \
"
