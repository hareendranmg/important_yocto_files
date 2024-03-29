# /home/hareendran/oe-core/layers/meta-qt5/recipes-qt/qt5/qtmultimedia_git.bb

require qt5.inc
require qt5-git.inc

LICENSE = "GFDL-1.3 & BSD-3-Clause & ( GPL-3.0-only & The-Qt-Company-GPL-Exception-1.0 | The-Qt-Company-Commercial ) & ( GPL-2.0-or-later | LGPL-3.0-only | The-Qt-Company-Commercial )"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtdeclarative"

inherit pkgconfig


EXTRA_QMAKEVARS_CONFIGURE += "${PACKAGECONFIG_CONFARGS}"



CXXFLAGS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', '-DMESA_EGL_NO_X11_HEADERS=1', d)}"

# Patches from https://github.com/meta-qt5/qtmultimedia/commits/b5.15
# 5.15.meta-qt5.1
SRC_URI += "\
    file://0001-qtmultimedia-fix-a-conflicting-declaration.patch \
"

# The same issue as in qtbase:
# http://errors.yoctoproject.org/Errors/Build/44914/
LDFLAGS:append:x86 = "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', ' -fuse-ld=bfd ', '', d)}"

SRCREV = "eeb34aae03b9395c9b3b45ab7c4f3055d086e894"

# Temporary work around for Qt5MultimediaConfig.cmake referencing non-existent videoeglvideonode directory
do_install:append() {
    install -d ${D}${OE_QMAKE_PATH_PLUGINS}/videoeglvideonode
}
FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS}/videoeglvideonode"
