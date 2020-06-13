#
# Copyright (c) Siemens AG, 2020
#
# Authors:
#  Jan Kiszka <jan.kiszka@siemens.com>
#
# This file is subject to the terms and conditions of the MIT License.  See
# COPYING.MIT file in the top-level directory.
#

inherit dpkg

SRC_URI = " \
    git://github.com/ARM-software/arm-trusted-firmware.git;protocol=https \
    file://rules"
SRCREV = "967a6d162d9dc1c5ae154f289bcdecc03cb9eb7c"

DEBIAN_BUILD_DEPENDS = "git"

S = "${WORKDIR}/git"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize

    echo "build/k3/generic/release/bl31.bin /usr/lib/arm-trusted-firmware/iot2050/" > ${S}/debian/install
}
