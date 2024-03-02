FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://restrict_sda_access.patch"

do_rootfs_prepend() {
    install -d ${WORKDIR}/sysroot/etc/security
    echo 'sda ALL=(ALL) /usr/bin/false' > ${WORKDIR}/sysroot/etc/security/sda
}
