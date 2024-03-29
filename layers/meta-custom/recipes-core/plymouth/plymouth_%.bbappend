FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://tachlog.png \
    file://spinner.plymouth \
"

PACKAGECONFIG = "pango drm"

EXTRA_OECONF += "--with-udev --with-runtimedir=/run"

do_install:append () {
    install -m 0644 ${WORKDIR}/tachlog.png ${D}${datadir}/plymouth/themes/spinner/watermark.png
    install -m 0644 ${WORKDIR}/spinner.plymouth ${D}${datadir}/plymouth/themes/spinner/spinner.plymouth
}